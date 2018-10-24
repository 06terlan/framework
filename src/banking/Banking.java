package banking;

import banking.ui.BankFrm;
import framework.FinCo;

import java.util.ArrayList;
import java.util.List;

public class Banking extends FinCo {

    private List<BankAccount> accounts;

    public Banking () {
        super();
        accounts = new ArrayList<>();
    }

    public void run() {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                main = new BankFrm(Banking.this);
                main.setVisible(true);
            }
        });
    }

    public List<BankAccount> getBankingAccounts(){
        return this.accounts;
    }

    public static void main(String[] args) {
        Banking creditCard = new Banking();
        creditCard.run();
    }

}
