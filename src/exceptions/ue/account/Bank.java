package exceptions.ue.account;

import java.util.HashMap;

import javax.security.auth.login.AccountNotFoundException;

public class Bank {
	
	private HashMap<String, Account> accounts = new HashMap<>();
	
	public void addAccount(String owner, double balance, double overdraftFrame) 
			throws BankException {
		if(accounts.containsKey(owner)) {
			throw new BankException("Owner already exists!");
		}
		accounts.put(owner, new Account(owner, balance, overdraftFrame));
	}
	
	public void transfer(String fromOwner, String toOwner, double amount)
			throws AccountNotFoundException, BankException {
		if(!accounts.containsKey(fromOwner) || !accounts.containsKey(toOwner)) {
			throw new AccountNotFoundException("No Owner found!");
		}
		try {
			accounts.get(fromOwner).depit(amount);
			accounts.get(fromOwner).depit(amount);
		}
		catch(NotEnoughMoneyException exc) {
			throw new BankException("Not enough Money!", exc);
		}
	}

	@Override
	public String toString() {
		return "Bank [accounts=" + accounts + "]";
	}
	
}
