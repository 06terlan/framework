package creditcard;

import java.time.LocalDate;

import framework.account.Account;
import framework.party.Party;

public abstract class CCAccount extends Account {
	private LocalDate expDate;
	private double mP;
	
    public LocalDate getExpDate() {
		return expDate;
	}

	public CCAccount(Party party, String accountNumber, LocalDate expDate) {
    	super(party, accountNumber);
    	this.expDate = expDate;
    }
	
	public abstract String getType();
}
