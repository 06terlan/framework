package banking;

import framework.party.Custormer;

public class SavingAccount extends BankAccount {

    private double interestRate = 0.0325;
    private String type = "Saving";

    public SavingAccount(Custormer party, String accountNumber, double interest) {
        super(party, accountNumber, interest);
    }

    public SavingAccount(Custormer party, String accountNumber) {
        super(party, accountNumber);
    }

	@Override
	public String getType() {
		return "Saving";
	}

}
