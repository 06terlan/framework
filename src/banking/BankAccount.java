package banking;

import framework.account.Account;
import framework.party.Party;

public abstract class BankAccount extends Account {


    private double interest;

    public BankAccount(Party party, String accountNumber, double interest) {
        super(party, accountNumber);
        this.interest = interest;
    }

    public abstract void addInterest();

}
