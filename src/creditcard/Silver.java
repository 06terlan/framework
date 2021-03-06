package creditcard;

import java.time.LocalDate;

import framework.party.Custormer;

public class Silver extends CCAccount {
	private double interestRate = 0.08;
	private double mP = 0.12;
	
    public Silver(Custormer party, String accountNumber, LocalDate expDate) {
        super(party, accountNumber, expDate);
    }

	@Override
	public String getType() {
		return "Silver";
	}
	
	@Override
	public double getMP() {
		return mP;
	}
}
