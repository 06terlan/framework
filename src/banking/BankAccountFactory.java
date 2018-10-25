package banking;

import framework.IAccountFactory;
import framework.account.Account;
import framework.party.Custormer;

public class BankAccountFactory implements IAccountFactory {
    protected BankAccountFactory() {}
    private static BankAccountFactory bankAccountFactory = null;

    public static BankAccountFactory getInstance() {
        if(bankAccountFactory == null) {
            bankAccountFactory = new BankAccountFactory();
        }
        return bankAccountFactory;
    }

	@Override
	public Account createAccount(Custormer party, String accountNumber, String type) {
		BankAccount account;
		
		if(type.equals("CheckingAccount")) {
			account = new CheckingAccount(party, accountNumber);
	        party.addAccount(account);
		}
		else {
			account = new SavingAccount(party, accountNumber);
	        party.addAccount(account);
		}
        
		return account;
	}
}
