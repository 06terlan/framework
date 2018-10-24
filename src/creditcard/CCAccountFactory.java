package creditcard;

import java.time.LocalDate;

import framework.AccountFactory;
import framework.account.Account;
import framework.party.Party;

public class CCAccountFactory extends AccountFactory {

    private CCAccountFactory() {}
	
	public static Account createBronzeCard(Party party, String accountNumber, LocalDate expDate) {
		Account account = new Bronze(party, accountNumber, expDate);
		party.addAccount(account);
		return account;
	}
	
	public static Account createSilverCard(Party party, String accountNumber, LocalDate expDate) {
		Account account = new Silver(party, accountNumber, expDate);
		party.addAccount(account);
		return account;
	}
	
	public static Account createGoldCard(Party party, String accountNumber, LocalDate expDate) {
		Account account = new Gold(party, accountNumber, expDate);
		party.addAccount(account);
		return account;
	}
}
