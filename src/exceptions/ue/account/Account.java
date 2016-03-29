package exceptions.ue.account;

public class Account {
	
	private String owner;
	private double balance;
	private double overdraftFrame;
	
	public Account(String owner, double balance, double overdraftFrame) {
		super();
		this.owner = owner;
		this.balance = balance;
		this.overdraftFrame = overdraftFrame;
	}
	
	public String getOwner() {
		return owner;
	}
	public double getBalance() {
		return balance;
	}
	public double getOverdraftFrame() {
		return overdraftFrame;
	}
	
	public void credit(double amount) {
		balance+=amount;
	}
	
	public void depit(double amount) throws NotEnoughMoneyException {
		if(balance+overdraftFrame-amount<0) {
			throw new NotEnoughMoneyException("Not enough money!");
		}
		else balance-=amount;
	}

}
