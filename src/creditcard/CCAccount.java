package creditcard;

import java.time.LocalDate;

import creditcard.rules.CCNotifyRule;
import framework.account.Account;
import framework.party.Custormer;
import framework.rules.NotifyRule;

public abstract class CCAccount extends Account {
	private LocalDate expDate;
	
    public LocalDate getExpDate() {
		return expDate;
	}

	public CCAccount(Custormer party, String accountNumber, LocalDate expDate) {
    	super(party, accountNumber);
    	this.expDate = expDate;
    }
	
	public abstract String getType();
	
	public abstract double getMP();
	
	public void sendNotification() {
		if(new CCNotifyRule().chech(this)) party.notifyOwner();
	}
}
