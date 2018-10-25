package framework.party;

import java.util.List;

import framework.account.IAccount;

public interface ICustomer {
	public void addAccount(IAccount account);
	public void removeAccount(IAccount account);
	public void notifyOwner();
	public List<IAccount> getAccounts();
}
