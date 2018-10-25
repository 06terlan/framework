package banking;

import framework.party.Party;

public class SavingAccount extends BankAccount {

    private double interestRate = 0.0325;
    private String type = "Saving";

    public SavingAccount(Party party, String accountNumber, double interest) {
        super(party, accountNumber, interest);
    }

    public SavingAccount(Party party, String accountNumber) {
        super(party, accountNumber);
    }

	@Override
	public String getType() {
		return "Saving";
	}

}
