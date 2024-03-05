package account.model;

public abstract class Account 
{
	private String holder;
	private int number = 0, agency, type;
	private float balance;
	
	public Account(String holder, int number, int agency, int type, float balance) 
	{
		this.holder = holder;
		this.number = number;
		this.agency = agency;
		this.type = type;
		this.balance = balance;
	}

	public String getHolder() {
		return holder;
	}

	public void setHolder(String holder) {
		this.holder = holder;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public int getAgency() {
		return agency;
	}

	public void setAgency(int agency) {
		this.agency = agency;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public float getBalance() {
		return balance;
	}

	public void setBalance(float balance) {
		this.balance = balance;
	}
	
	public boolean withdraw(float amount) 
	{ 
		
		if(this.getBalance() < amount) 
		{
			System.out.println("\n Insufficient balance!");
			return false;
		}
			
		this.setBalance(this.getBalance() - amount);
		return true;
	}
	
	public void deposit(float amount) 
	{
		this.setBalance(this.getBalance()+ amount);
	}
	
	public void print() 
	{

		String type = "";
		
		switch(this.type) {
		case 1:
			type = "Checking Account";
		break;
		case 2:
			type = "Savings Account";
		break;
		}
		
		System.out.println("***********************************************************");
		System.out.println("\tAccount Details:");
		System.out.println("***********************************************************");
		System.out.println("\tAccount Number: " + this.number);
		System.out.println("\tAgency: " + this.agency);
		System.out.println("\tAccount Type: " + type);
		System.out.println("\tHolder: " + this.holder);
		System.out.println("\tBalance: " + this.balance + "\n");

	}
	
	
}
