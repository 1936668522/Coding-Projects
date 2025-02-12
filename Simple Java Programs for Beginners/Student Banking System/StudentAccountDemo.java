/**
 * @author - Thomas Lee
 * This program/class is to test every methods from StudentAccount and RewardsAccount.
 */

package assg3_lic20;

public class StudentAccountDemo {

	public static void main(String[] args) {
		StudentAccount account1, account2, account3, account4, account5, account6, account7, accountx;
		
		RewardsAccount rewardAccount, rewardAccount1;
				
		account1 = new StudentAccount();
		account2 = new StudentAccount(122.34);
		account3 = new StudentAccount(87);
		account4 = new StudentAccount(234.67);
		account5 = new StudentAccount(97.77);
		account6 = new StudentAccount(67.89);
		account7 = new StudentAccount(100);
		accountx = new StudentAccount(20.32);
		
		//Use those two variables to test the RewardsAccount class.
		rewardAccount = new RewardsAccount(700);
		rewardAccount1 = new RewardsAccount(59);


	
		//To test out the toString methods and making sure the constructor works properly.
		System.out.println("Account 1: " + "\n" + account1.toString() + "\n");
		System.out.println("Account 2: " + "\n" + account2.toString() + "\n");
		System.out.println("Account 3: " + "\n" + account3.toString() + "\n");
		System.out.println("Account 4: " + "\n" + account4.toString() + "\n");

		//To test out if printInto() method works properly.
		System.out.println("Account 5: ");
		account5.printInfo();
		System.out.println("\n" + "Account 6: ");
		account6.printInfo();
		System.out.println("\n" + "Account 7: ");
		account7.printInfo();
		System.out.println("\n" + "Account x: ");
		accountx.printInfo();
		
		//To test getCounter(), since counter is static variable, it will count how much accounts are made.
		System.out.println("\n" + "There are " + StudentAccount.getCounter() + " Student Account are made");

		//To test setBalance() methods, getBalancer(), and getAccNo() methods work properly.
		account3.setBalance(20.32);
		System.out.println("\n" + "The new balance of account 3 is: " + account3.getBalance());
		System.out.println("The account number of account 3 is: " + account3.getAccNo());
		System.out.println("The account number of account x is: " + accountx.getAccNo());
		
		//To test deposit() method.
		account1.deposit(450);
		System.out.println("\n" + "The new balance of account 1 is: " + account1.getBalance());
		//To test deposit() method when input is less or equal to 0
		account1.deposit(0);
		account1.deposit(-3);
		
		//To test charge() method.
		account2.charge(195);
		System.out.println("\n" + "The new balance of account 2 is: " + account2.getBalance());
		//To test charge()method when input is less than 0, it will show "Input ERROR"
		account2.charge(-3);
		account2.charge(0);
		
		//To test if transfer() method works properly.
		account4.transfer(account2, 100);
		//To check if those two account's balance changed.
		System.out.println("\n" + "The new balance of account 2 is: " + account2.getBalance());
		System.out.println("The new balance of account 4 is: " + account4.getBalance());
		
		/**
		 * To check if compareTo() method works properly, if the account is larger than obj account 
		 * it will show 1, if it's equal it will show 0, if less, it will show -1.
		 */
		System.out.println("\n" + accountx.compareTo(account6));// because accountx is less than account 6, so it will show -1
		System.out.println(accountx.compareTo(account3));//because accountx and account3 have same amount, it will show 0.
		System.out.println(account7.compareTo(account5));// because account7 have more amount than account 5 , show 1.
		
		//To test if RewardsAccount constructor work properly. If it work properly then the rewards should be 4% of it's balance.
		//And also to check if printInfo works properly.
		System.out.println("\n" +"Reward Account: ");
		rewardAccount.printInfo();
		
		//This is to test other possibility where balance is less than 100, then there will be zero reward.
		//And also to check if toString works properly.
		System.out.println("\n" + "Reward Account 1: " + "\n" + rewardAccount1.toString() + "\n");
		
		
		//To check if getRewards() method works properly.
		System.out.println("The rewards from Account 9 is: " + rewardAccount.getRewards());
		System.out.println("The rewards from Account 10 is: " + rewardAccount1.getRewards() + "\n");
		
		//To check if redeemRewards() method works properly.
		rewardAccount.redeemRewards();
		System.out.println("The new information of Account 9 is: " + "\n" + rewardAccount.toString() + "\n");
		//To check other possibility of redeemRewards() method.
		rewardAccount1.redeemRewards();
		
		//To check if deposit() method works properly.
		rewardAccount.deposit(200);
		System.out.println("\n" + "The new information of Account 9 is: " + "\n" + rewardAccount.toString() + "\n");
		rewardAccount1.deposit(400);
		System.out.println("\n" + "The new information of Account 10 is: " + "\n" + rewardAccount1.toString() + "\n");
		
	}

}
