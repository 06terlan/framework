package banking;

import framework.AccountFactory;
import framework.party.Party;

public class BankAccountFactory extends AccountFactory {
    protected BankAccountFactory() {}
    private static BankAccountFactory bankAccountFactory = null;

    public static BankAccountFactory getInstance() {
        if(bankAccountFactory == null) {
            bankAccountFactory = new BankAccountFactory();
        }
        return bankAccountFactory;
    }

    public BankAccount createCheckingAccount(Party party, String accountNumber) {
        BankAccount account = new CheckingAccount(party, accountNumber);
        party.addAccount(account);
        return account;
    }

    public BankAccount createSavingAccount(Party party, String accountNumber) {
        BankAccount account = new SavingAccount(party, accountNumber);
        party.addAccount(account);
        return account;
    }
}
