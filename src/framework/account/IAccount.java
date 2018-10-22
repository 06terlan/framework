package framework.account;

import framework.account.entry.Entry;
import framework.party.Party;

public interface IAccount {

    public double getBalance();
    public void addEntry(Entry entry);
    public Party getOwner();
    public void report();
}
