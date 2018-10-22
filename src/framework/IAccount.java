package framework;

import framework.party.Party;

public interface IAccount {

    public double getBalance();
    public void addEntry();
    public Party getOwner();

}
