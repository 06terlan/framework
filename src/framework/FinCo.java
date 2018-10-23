package framework;

import java.util.ArrayList;
import java.util.List;
import javax.swing.*;

import framework.party.Party;
import framework.ui.MainScreen;

public class FinCo extends JFrame {

    /****
     * init variables in the object
     ****/
    private List<Party> parties;
    private JFrame main;
    
    public FinCo () {
    	parties = new ArrayList<>();
    }

    public static void main(String[] args) { 
    	FinCo finCo = new FinCo();
    	finCo.run();
    }
    
    public void run() {
    	java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
            	main = new MainScreen();
            	main.setVisible(true);
            }
      });
    }
	
	public AccountFactory accountFactory() {
    	return AccountFactory.getInstance();
    }
    
    public PartyFactory partyFactory() {
    	return PartyFactory.getInstance();
    }
    
    public void addInterest() {
    	parties.stream().flatMap(p->p.getAccounts().stream())
    		.forEach(a->a.addInterest());
    }
}
