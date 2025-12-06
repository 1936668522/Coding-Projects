### Code based on https://lightning.ai/lightning-ai/studios/image-segmentation-with-pytorch-lightning

import torch
import torch.nn as nn
import torchmetrics
import pytorch_lightning as pl
from pytorch_lightning import loggers as pl_loggers
from torch.utils.data import Dataset, DataLoader
import torchvision.transforms as transforms
import torchvision

transform_source = transforms.Compose([transforms.ToTensor(),
                                transforms.Resize((256,256)),
                                transforms.Normalize((0.485, 0.456, 0.406), (0.229, 0.224, 0.225))])

# Target transform for segmentation masks - don't convert to tensor with ToTensor (normalizes to [0,1])
# Instead resize as PIL and convert manually to preserve integer labels
transform_target = transforms.Compose([transforms.Resize((256,256), interpolation=transforms.InterpolationMode.NEAREST),
                                        transforms.PILToTensor()])

# Oxford-IIIT Pet Dataset - simpler segmentation dataset with 3 classes (pet, background, border)
train_dataset = torchvision.datasets.OxfordIIITPet("seg_data/",split="trainval",target_types="segmentation",transform=transform_source,target_transform=transform_target,download=True)
train_dataset, val_dataset, test_dataset = torch.utils.data.random_split(train_dataset, [int(len(train_dataset)*0.8), int(len(train_dataset)*0.1), len(train_dataset) - int(len(train_dataset)*0.9)])

train_loader = DataLoader(train_dataset,batch_size=8,shuffle=True)
val_loader = DataLoader(val_dataset,batch_size=8)
test_loader = DataLoader(test_dataset,batch_size=8)


class LitNetwork(pl.LightningModule):
    def __init__(self):
        super(LitNetwork, self).__init__()

        self.model = torchvision.models.segmentation.fcn_resnet50(num_classes=3)  # 3 classes for Oxford-IIIT Pet
        self.loss_func = torch.nn.CrossEntropyLoss()
        self.val_iou = torchmetrics.JaccardIndex(task="multiclass", num_classes=3, average='macro')  # IoU is better for segmentation
        self.test_iou = torchmetrics.JaccardIndex(task="multiclass", num_classes=3, average='macro')

    def forward(self, x):
        return self.model(x)["out"]

    def configure_optimizers(self):
        optimizer = torch.optim.Adam(self.parameters(), lr=1e-4)
        return optimizer

    def training_step(self, data, batch_idx):
        im, targets = data[0], data[1]
        targets = targets - 1  # Oxford Pet uses 1,2,3; convert to 0,1,2
        outs = self.forward(im)
        loss = self.loss_func(outs, targets.long().squeeze(1))
        self.log("train_loss",loss,prog_bar=True,on_step=True,on_epoch=True,batch_size=8,sync_dist=True)
        return loss
    
    def validation_step(self, val_data, batch_idx):
        im, targets = val_data[0], val_data[1]
        targets = targets - 1  # Oxford Pet uses 1,2,3; convert to 0,1,2
        outs = self.forward(im)
        self.val_iou(outs,targets.long().squeeze(1))
        self.log("val_iou",self.val_iou,prog_bar=True,on_step=False,on_epoch=True,sync_dist=True)
        return None

    def test_step(self, test_data, batch_idx):
        im, targets = test_data[0], test_data[1]
        targets = targets - 1  # Oxford Pet uses 1,2,3; convert to 0,1,2
        outs = self.forward(im)
        self.test_iou(outs,targets.long().squeeze(1))
        self.log("test_iou",self.test_iou,prog_bar=True,on_step=False,on_epoch=True,sync_dist=True)
        return None


model = LitNetwork()
checkpoint = pl.callbacks.ModelCheckpoint(monitor='val_iou', save_top_k=1, mode='max')
logger = pl_loggers.TensorBoardLogger(save_dir="my_logs")
#logger = pl_loggers.CSVLogger(save_dir="my_logs",name="my_csv_logs")

device = "gpu" # Use 'mps' for Mac M1 or M2 Core, 'gpu' for Windows with Nvidia GPU, or 'cpu' for Windows without Nvidia GPU

trainer = pl.Trainer(max_epochs=2, accelerator=device, callbacks=[checkpoint], logger=logger)
trainer.fit(model,train_loader,val_loader)
    
trainer.test(ckpt_path="best", dataloaders=test_loader)

#Visualize Example Output
import matplotlib.pyplot as plt
import numpy as np
from PIL import Image

# Load and preprocess image
im = Image.open("example_cat.jpg")
im_tensor = transform_source(im).unsqueeze(0).to(model.device)  # Move to same device as model

# Run inference
model.eval()
with torch.no_grad():
    out = model(im_tensor)
    out = torch.argmax(out, dim=1).squeeze(0)
    out = out.detach().cpu().numpy()

# Create color map for visualization
colors = np.array([[0, 0, 255], [255, 0, 0], [0, 255, 0]], dtype=np.uint8)  # background, class1, class2
out_rgb = colors[out]

plt.figure(figsize=(10, 5))
plt.subplot(1,2,1)
plt.imshow(im)
plt.title('Original Image')
plt.axis('off')
plt.subplot(1,2,2)
plt.imshow(out_rgb)
plt.title('Segmentation Output')
plt.axis('off')
plt.show()
