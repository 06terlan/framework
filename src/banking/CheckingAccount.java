package banking;

import framework.account.entry.Entry;
import framework.party.Party;

import java.time.LocalDate;

public class CheckingAccount extends BankAccount {

    private double interestRate = 0.01;
    private String type = "Checking";

    public CheckingAccount(Party party, String accountNumber, double interest) {
        super(party, accountNumber, interest);
    }

    public CheckingAccount(Party party, String accountNumber) {
        super(party, accountNumber);
    }
}
