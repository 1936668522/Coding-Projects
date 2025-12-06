# Computer Vision Lab – Image Segmentation with PyTorch Lightning

This repo contains my solution for a computer vision lab using **PyTorch** and **PyTorch Lightning** to train
a simple semantic segmentation model on the **Oxford-IIIT Pet** dataset.

The goal of the lab:

- Train a segmentation network for at least 2 epochs.
- Log training metrics with **TensorBoard**.
- Run inference on an example image and visualize the segmentation mask.

---

## 1. Project Structure

```text
.
├── PyTorch_Lightning_Seg_Example.py   # Main training / inference script
├── example_cat.jpg                    # Example test image
├── my_logs/                           # TensorBoard logs (ignored by git)
└── README.md
