package framework.account;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import framework.account.entry.Entry;
import framework.party.Party;

public class Account implements IAccount {
	
	
	private String accountNumber;
	private List<Entry> entries;
	private double interestRate = 5;
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
    	party.notifyOwner();
    }

    @Override
    public Party getOwner() {
        return party;
    }
    
    @Override
    public void report() {
    	System.out.println(entries);
    }
    
    @Override
    public void addInterest() {
    	double rate = getBalance() * interestRate / 100;
    	if(rate > 0) entries.add(new Entry(rate, LocalDate.now(), "Interest Added"));
    }

	public String getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}
}
