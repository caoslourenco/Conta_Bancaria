package account.model;

public class SavingsAccount extends Account
{
	private int anniversary;
	
	public SavingsAccount(String holder, int number, int agency, int type, float balance, int anniversary) {
		super(holder, number, agency, type, balance);
		this.anniversary = anniversary;
	}

	public int getAnniversary() 
	{
		return anniversary;
	}

	public void setAnniversary(int anniversary) 
	{
		this.anniversary = anniversary;
	}
	
	@Override 
	public void print() 
	{
		super.print();
		System.out.println("Account Anniversary: " + this.anniversary);
	}
}
