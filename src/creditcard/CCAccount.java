package creditcard;

import java.time.LocalDate;

import framework.account.Account;
import framework.party.Party;

public abstract class CCAccount extends Account {
	private LocalDate expDate;
	
    public CCAccount(Party party, String accountNumber, LocalDate expDate) {
    	super(party, accountNumber);
    	this.expDate = expDate;
    }
}
