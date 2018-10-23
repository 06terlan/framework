package banking;

import framework.party.Party;

public class CheckingAccount extends BankAccount {

    public CheckingAccount(Party party, String accountNumber, double interest) {
        super(party, accountNumber, interest);
    }

    @Override
    public void addInterest() {

    }
}
