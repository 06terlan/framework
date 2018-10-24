package creditcard.rules;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

import framework.account.Account;
import framework.party.Person;
import framework.rules.INotifyRule;

public class CCNotifyRule implements INotifyRule{
	private List<Predicate<Account>> personRules = new ArrayList<>();
	private List<Predicate<Account>> companynRules = new ArrayList<>();
	
	public CCNotifyRule() {
		//less than 0
		personRules.add(new Predicate<Account>() {
			@Override
			public boolean test(Account t) {
				return t.getBalance() < 0;
			}
		});
		
		//greater than 400
		personRules.add(new Predicate<Account>() {
			@Override
			public boolean test(Account t) {
				return t.getEntries().get(t.getEntries().size()-1).getAmount() > 400;
			}
		});
		
		companynRules.add(new Predicate<Account>() {
			@Override
			public boolean test(Account t) {
				return true;
			}
		});
	}
	
	@Override
	public boolean chech(Account account) {
		
		if(account.getOwner() instanceof Person) {
			for(Predicate<Account> predicate: personRules) {
				if(predicate.test(account)) return true;
			}
		}
		else {
			for(Predicate<Account> predicate: companynRules) {
				if(predicate.test(account)) return true;
			}
		}
		
		return false;
	}
}
