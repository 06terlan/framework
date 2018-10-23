package framework.account;

import java.time.LocalDate;
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

    @Override
    public void depositMoney(double mooney) {
    	entries.add(new Entry(mooney, LocalDate.now(), "Deposit Money"));
    }

    @Override
    public Party getOwner() {
        return party;
    }
    
    @Override
    public void report() {
    	System.out.println(entries);
    }

	public String getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}
}
