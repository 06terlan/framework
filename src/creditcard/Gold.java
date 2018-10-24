package creditcard;

import java.time.LocalDate;

import framework.party.Party;

public class Gold extends CCAccount {
	private double interestRate = 6;
	
    public Gold(Party party, String accountNumber, LocalDate expDate) {
        super(party, accountNumber, expDate);
    }

	@Override
	public String getType() {
		return "Gold";
	}
}
