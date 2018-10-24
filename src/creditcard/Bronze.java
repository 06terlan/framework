package creditcard;

import java.time.LocalDate;

import framework.party.Party;

public class Bronze extends CCAccount {
	private double interestRate = 10;
	
    public Bronze(Party party, String accountNumber, LocalDate expDate) {
        super(party, accountNumber, expDate);
    }
    
    @Override
	public String getType() {
		return "Bronze";
	}
}
