package creditcard;

import creditcard.ui.CardFrm;
import framework.AccountFactory;
import framework.PartyFactory;

public class CreditCard extends framework.FinCo {
    public CreditCard () {
    	super();
    }
    
    public void run() {
    	java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
            	main = new CardFrm(CreditCard.this);
            	main.setVisible(true);
            }
    	});
    }
    
    public static void main(String[] args) { 
    	CreditCard creditCard = new CreditCard();
    	creditCard.run();
    }
}
