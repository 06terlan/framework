package framework;

import framework.account.Account;
import framework.account.IAccount;
import framework.party.Party;

public class AccountFactory {
	
	public IAccount createAccount(Party party, String accountNumber) {
		return new Account(party, accountNumber);
	}
}
