package framework;

import framework.party.Party;

public class Account implements IAccount {
	
	private String accountNumber;
	
    @Override
    public double getBalance() {
        return 0;
    }

    @Override
    public void addEntry() {

    }

    @Override
    public Party getOwner() {
        return null;
    }

    public void getReport() {

    }
}
