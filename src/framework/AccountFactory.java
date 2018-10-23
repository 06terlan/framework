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
	
	public Account createAccount(Party party, String accountNumber) {
		Account account = new Account(party, accountNumber);
		party.addAccount(account);
		return account;
	}
}
