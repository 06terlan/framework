package framework;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;

import framework.account.Account;
import framework.party.Party;
import framework.ui.MainScreen;

public class FinCo extends JFrame {
    protected List<Party> parties;
    protected List<Account> accounts;
    protected JFrame main;
    
    public FinCo () {
    	parties = new ArrayList<>();
    	accounts = new ArrayList<>();
    }

    public static void main(String[] args) { 
    	FinCo finCo = new FinCo();
    	finCo.run();
    }
    
    public void run() {
    	java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
            	main = new MainScreen(FinCo.this);
            	main.setVisible(true);
            }
    	});
    }
    
    public void addInterest() {
    	parties.stream().flatMap(p->p.getAccounts().stream())
    		.forEach(a->a.addInterest());
    }
    
    public List<Party> getParties(){
    	return parties;
    }

    public List<Account> getAccounts(){
        return accounts;
    }

    public Account getAccountByNumber(String number) {
        for(Account account : accounts) {
            if (account.getAccountNumber().equals(number)) {
                return account;
            }
        }
        return null;
    }
}
