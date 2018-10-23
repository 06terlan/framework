package framework;

import framework.account.Account;
import framework.account.IAccount;
import framework.party.Party;

public class AccountFactory {
	
	protected AccountFactory() {}
	private static AccountFactory accountFactory = null;
	
	public static AccountFactory getInstance() {
		if(accountFactory == null) {
			accountFactory = new AccountFactory();
		}
		
		return accountFactory;
	}
	
	public IAccount createAccount(Party party, String accountNumber) {
		return new Account(party, accountNumber);
	}
}
