package framework;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;

import framework.party.Party;
import framework.ui.MainScreen;

public class FinCo extends JFrame {
    protected List<Party> parties;
    protected JFrame main;
    
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
}
