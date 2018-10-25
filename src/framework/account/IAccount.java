package framework.account;

import java.util.List;

import framework.account.entry.IEntry;
import framework.party.ICustomer;

public interface IAccount {
	public String getAccountNumber();
	public double getBalance();
	public void depositMoney(double money);
	public void withdrawMoney(double money);
	public ICustomer getOwner();
	public void addInterest();
	public List<IEntry> getEntries();
	public void sendNotification();
}
