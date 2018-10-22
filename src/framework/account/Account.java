package framework.account;

import java.util.ArrayList;
import java.util.List;

import framework.account.entry.Entry;
import framework.party.Party;

public class Account implements IAccount {
	
	private String accountNumber;
	private List<Entry> entries;
	private Party party;
	
	public Account(Party party, String accountNumber) {
		this.accountNumber = accountNumber;
		this.party = party;
		
		entries = new ArrayList<>();
	}
	
    @Override
    public double getBalance() {
        return entries.stream().mapToDouble(e->e.getAmount()).sum();
    }

    public void addEntry(Entry entry) {
    	entries.add(entry);
    }

    @Override
    public Party getOwner() {
        return party;
    }
    
    @Override
    public void report() {

    }

	public String getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}
}
