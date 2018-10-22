package framework.account;

import framework.Party;
import framework.account.entity.Entry;

public interface IAccount {

    public double getBalance();
    public void addEntry(Entry entry);
    public Party getOwner();
    public void report();
}
