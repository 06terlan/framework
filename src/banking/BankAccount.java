package banking;

import banking.rules.BankNotifyRule;
import creditcard.rules.CCNotifyRule;
import framework.account.Account;
import framework.party.Party;

public abstract class BankAccount extends Account {

    private double interest;

    public BankAccount(Party party, String accountNumber, double interest) {
        super(party, accountNumber);
        this.interest = interest;
    }

    public BankAccount(Party party, String accountNumber) {
        super(party, accountNumber);
    }

    public abstract String getType();
    
    public void sendNotification() {
		if(new BankNotifyRule().chech(this)) party.notifyOwner();
	}
}
