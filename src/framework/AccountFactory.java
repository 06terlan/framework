package framework;

import framework.account.Account;
import framework.account.IAccount;
import framework.party.Custormer;

public class AccountFactory implements IAccountFactory{
	
	protected AccountFactory() {}
	private static AccountFactory accountFactory = null;
	
	public static AccountFactory getInstance() {
		if(accountFactory == null) {
			accountFactory = new AccountFactory();
		}
		
		return accountFactory;
	}
	
	public Account createAccount(Custormer party, String accountNumber, String type) {
		Account account = new Account(party, accountNumber);
		party.addAccount(account);
		return account;
	}
}
