package creditcard;

import framework.account.Account;
import framework.party.Party;

public abstract class CCAccount extends Account {
    public CCAccount(Party party, String accountNumber) {
        super(party, accountNumber);
    }
}
