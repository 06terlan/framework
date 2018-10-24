package creditcard;

import java.time.LocalDate;

import framework.party.Party;

public class Bronze extends CCAccount {
	private double interestRate = 0.10;
	private double mP = 0.14;
	
    public Bronze(Party party, String accountNumber, LocalDate expDate) {
        super(party, accountNumber, expDate);
    }
    
    @Override
	public String getType() {
		return "Bronze";
	}

	@Override
	public double getMP() {
		return mP;
	}
}
