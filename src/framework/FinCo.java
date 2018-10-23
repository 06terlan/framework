package framework;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import framework.account.IAccount;
import framework.party.Company;
import framework.party.Party;
import framework.party.Person;

public class FinCo {
	
	private List<Party> parties;
    
	public FinCo() {
		parties = new ArrayList<>();
	}
	
	public AccountFactory accountFactory() {
    	return AccountFactory.getInstance();
    }
    
    public PartyFactory partyFactory() {
    	return PartyFactory.getInstance();
    }
	
	public static void main(String[] args) {
    	FinCo finCo = new FinCo();
    	
    	Person personTarlan = finCo.partyFactory().createPerson("Tarlan", "street", "city", "state", 12222, "email", LocalDate.of(1995, 3, 16));
    	Person personOljas = finCo.partyFactory().createPerson("Oljas", "street", "city", "state", 12223, "email", LocalDate.of(1994, 3, 16));
    	
    	Company company = finCo.partyFactory().createCompany("Company", "street", "city", "state", 1324, "email");
    	company.hirePerson(personTarlan);
    	company.hirePerson(personOljas);
    	
    	System.out.println(company.employeesNumber());
    	
    	IAccount account = finCo.accountFactory().createAccount(company, "1");
    	account.depositMoney(1000);
    	account.report();
    }
}
