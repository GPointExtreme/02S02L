package exceptions.ue.account;

import java.util.HashMap;

public class Bank {
	
	private HashMap<String, Account> accounts = new HashMap<>();
	
	public void addAccount(String owner, double balance, double overdraftFrame) 
			throws BankException {
		if(accounts.containsKey(owner)) {
			throw new BankException("Owner already exists!");
		}
		accounts.put(owner, new Account(owner, balance, overdraftFrame));
	}

}
