package creditcard;

import java.time.LocalDate;

import framework.party.Custormer;

public class Gold extends CCAccount {
	private double interestRate = 0.06;
	private double mP = 0.10;
	
    public Gold(Custormer party, String accountNumber, LocalDate expDate) {
        super(party, accountNumber, expDate);
    }

	@Override
	public String getType() {
		return "Gold";
	}
	
	@Override
	public double getMP() {
		return mP;
	}
}
