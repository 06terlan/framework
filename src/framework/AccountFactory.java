package framework;

import framework.account.Account;
import framework.account.IAccount;

public class AccountFactory {
	
	public IAccount createAccount(Party party, String accountNumber) {
		return new Account(party, accountNumber);
	}
}
