package creditcard;

import java.time.LocalDate;

import framework.party.Party;

public class Silver extends CCAccount {
	private double interestRate = 8;
	
    public Silver(Party party, String accountNumber, LocalDate expDate) {
        super(party, accountNumber, expDate);
    }

}
