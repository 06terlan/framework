package framework.party;

import framework.account.Account;

import java.util.ArrayList;
import java.util.List;

public class Party implements IParty {

    private String name;
    private String street;
    private String city;
    private String state;
    private int zip;
    private String email;

    private List<Account> accounts = new ArrayList<>();

    protected Party(String name, String street, String city, String state, int zip, String email) {
        this.name = name;
        this.street = street;
        this.city = city;
        this.state = state;
        this.zip = zip;
        this.email = email;
    }

    public void addAccount(Account account) {
        accounts.add(account);
    }

    public void removeAccount(Account account) {
        accounts.remove(account);
    }

    public void notifyOwner() {
        System.err.println("Message sent to the owner: " + name);
    }
    
    public List<Account> getAccounts(){
    	return accounts;
    }
}
