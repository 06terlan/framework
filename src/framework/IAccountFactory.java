package framework;

import framework.account.Account;
import framework.party.Custormer;

public interface IAccountFactory {
	public Account createAccount(Custormer party, String accountNumber, String type);
}
