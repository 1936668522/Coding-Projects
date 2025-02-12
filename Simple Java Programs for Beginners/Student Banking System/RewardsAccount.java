/**
 * @author - Thomas Lee
 * This class/program is a sub class of StduentAccount class.
 * It's for reward system.
 */

package assg3_lic20;

public class RewardsAccount extends StudentAccount {
	
	private double rewards;
	
	/**
	 * Default constructor for to set rewards to zero
	 */
	public RewardsAccount() 
	{
		super();
		rewards = 0;
	}
	
	/**
	 * This constructor will provide the balance for initial account, if the balance is over
	 * $100, then 4%(0.04) of the balance will be the rewards.
	 * @param balance
	 */
	public RewardsAccount(double balance)
	{
		super(balance); 
		if(balance >= 100)
		{
			rewards = 0.04 * balance;
		}
		else
		{
			rewards = 0;
		}
	}
	
	/**
	 * this method is to get the amount of rewards.
	 */
	public double getRewards()
	{
		return rewards;
	}
	
	
	/**
	 * this method is to redeem the rewards to account balance
	 */
	public void redeemRewards()
	{
		if(rewards >= 20)
		{
			super.setBalance(getBalance() + rewards);// call parent class of setBalance get the getBalance and then puls rewads.
			rewards = 0;
		}
		else
		{
			System.out.println("Insufficient amount of rewards for redemption");
		}
	}
	
	/**
	 * this method is to return the account number, current balance, and rewards balance.
	 */
	public String toString()
	{
		return "Account number: " + getAccNo() + "\n" + "Current balance: "
				+ getBalance() + "\n" + "Rewards balance: " + rewards;
	}
	
	
	/**
	 * this method is to let 4% of balance to be the rewards if the balance is over 100.
	 */
	public void deposit(double balance)
	{
		super.deposit(balance);
		if(balance < 0)
		{
			System.out.println("Sorry you can't deposit 0.");
		}
		if(balance >= 100)
			rewards = rewards + (balance * 0.04);
	}
	
	
	/**
	 * this method is to display the information of account number, current balance and rewards balance.
	 */
	public void printInfo()
	{
		System.out.println("Account number: " + getAccNo());
		System.out.println("Current balance: " + getBalance());
		System.out.println("Rewards balance: " + rewards);
	}
	
}
