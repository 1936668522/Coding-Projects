/**
 * @author - Thomas Lee
 * This program/class is to manipulate or change the account Number, balance, and counters. 
 */

package assg3_lic20;

public class StudentAccount implements Comparable<StudentAccount> {

	private  long accNo = 1;
	private double balance;
	private static long counter = 0;
	
	/**
	 * Default constructor that initial balance to zero.
	 * account number equal to the value of counter.
	 */
	public StudentAccount()
	{
		accNo = accNo + counter;
		balance = 0;
		counter++;
	}
	
	/**
	 * constructor that make balance as parameter and automatically generate account number
	 * @param balance to provide an initial balance.
	 */
	public StudentAccount(double balance)
	{
		accNo = accNo + counter;
		this.balance = balance;
		counter++;
	}
	
	/**
	 * This  method is to used for retrieve the account number
	 * @param accNo to get the account number.
	 */
	public long getAccNo()
	{
		return accNo;
	}
	
	/**
	 * this method is to used to retrieve the balance
	 * @param balance to get the balance
	 */
	public double getBalance()
	{
		return balance;
	}
	
	/**
	 * this method is to used to retrieve the number of accounts created.
	 * @param counter to get the counter of accounts.
	 */
	public static long getCounter()
	{
		return counter;
	}
	
	
	/**
	 * this method is to used to set the account balance
	 * @param balance is used to set the balance.
	 */
	public void setBalance(double balance)
	{
		this.balance = balance;
	}
	
	
	/**
	 * this method is to make a deposit.
	 * @param balance is the input that will added to "this.balance" to get a new amount of balance.
	 */
	public void deposit(double balance)
	{
		if(balance <= 0)
		{
			System.out.println("Input ERROR.");
		}
		else
		{
			this.balance = this.balance + balance;
		}
	}
	
	
	/**
	 * This method is to charge the amount
	 * @param balance is the amount that will be charged.
	 * Use "this.balance" to minus the new amount to get a new balance.
	 */
	public void charge(double balance)
	{
		if(balance <= 0)
		{
			System.out.println("Input ERROR");
		}
		else
		{
			this.balance = this.balance - balance;
		}
	}
	
	
	/**
	 * this method is to transfer from one student account to another.
	 * @param obj is the student account that will receive the amount
	 * @param balance is the balance/amount that will give to other account.
	 */
	public void transfer(StudentAccount obj, double balance)
	{
		if(balance < 0)
		{
			System.out.println("The amount can't be transfer.");
		}
		else
		{
			this.balance = this.balance - balance;
			this.balance = (double)Math.round(this.balance*100)/100;
			obj.balance = obj.balance + balance;
			obj.balance = (double)Math.round(obj.balance * 100)/100;
		}
	}
	
	
	/**
	 * this method is to display the information of account number and balance
	 */
	public void printInfo()
	{
		System.out.println("Account number: " + accNo);
		System.out.println("Current balance: " + balance);
	}
	
	
	/**
	 * This method returns a String object with account information.
	 */
	public String toString()
	{
		return "Account number: " + accNo + "\n" + "Current balance: " + balance;		
	}

	
	/**
	 * this method is to compare the balance between two accounts.
	 */
	@Override
	public int compareTo(StudentAccount obj) 
	{
		if(this.balance > obj.balance)
		{
			return 1;
		}
		else if (this.balance == obj.balance)
		{
			return 0;
		}
		else
			return -1;
	}	
}
