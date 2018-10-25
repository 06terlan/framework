package banking;

import framework.account.entry.Entry;
import framework.party.Custormer;

import java.time.LocalDate;

public class CheckingAccount extends BankAccount {

    private double interestRate = 0.01;
    private String type = "Checking";

    public CheckingAccount(Custormer party, String accountNumber, double interest) {
        super(party, accountNumber, interest);
    }

    public CheckingAccount(Custormer party, String accountNumber) {
        super(party, accountNumber);
    }

	@Override
	public String getType() {
		return "Checking";
	}
}
