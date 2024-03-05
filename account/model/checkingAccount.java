package account.model;

public class CheckingAccount extends Account
{
	private float overdraftLimit;
	
	public CheckingAccount(String holder, int number, int agency, int type, float balance, float overdraftLimit) 
	{
		super(holder, number, agency, type, balance);
		this.overdraftLimit = overdraftLimit;
	}
	
	public float getOverdraftLimit() {
		return overdraftLimit;
	}
	
	public void setOverdraftLimit(float overdraftLimit) {
		this.overdraftLimit = overdraftLimit;
	}
	
	@Override
	public boolean withdraw(float amount) 
	{
		if (this.getBalance() + this.getOverdraftLimit() < amount) 
		{
			System.out.println("\n Insufficient balance!");
			return false;
		}
		
		this.setBalance(this.getBalance() - amount);
		return true;
	}
	
	@Override
	public void print() 
	{
		super.print();
		System.out.println("Overdraft Limit: " + this.overdraftLimit);
	}
}
