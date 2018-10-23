package banking;

import framework.party.Party;

public class SavingAccount extends BankAccount {

    public SavingAccount(Party party, String accountNumber, double interest) {
        super(party, accountNumber, interest);
    }

    @Override
    public void addInterest() {

    }
}
