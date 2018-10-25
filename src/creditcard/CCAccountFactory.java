package creditcard;

import java.time.LocalDate;

import framework.AccountFactory;
import framework.IAccountFactory;
import framework.account.Account;
import framework.party.Custormer;

public class CCAccountFactory implements IAccountFactory {

	protected CCAccountFactory() {}
	private static CCAccountFactory accountFactory = null;
	
	public static CCAccountFactory getInstance() {
		if(accountFactory == null) {
			accountFactory = new CCAccountFactory();
		}
		
		return accountFactory;
	}

	public Account createAccount(Custormer party, String accountNumber, LocalDate expDate, String type) {
		Account account;
		
		if(type.equals("BronzeCard")) {
			account = new Bronze(party, accountNumber, expDate);
			party.addAccount(account);	
		}
		else if(type.equals("SilverCard")){
			account = new Silver(party, accountNumber, expDate);
			party.addAccount(account);
		}
		else {
			account = new Gold(party, accountNumber, expDate);
			party.addAccount(account);
		}
		
		return account;
	}

	@Override
	public Account createAccount(Custormer party, String accountNumber, String type) {
		return null;
	}
}
