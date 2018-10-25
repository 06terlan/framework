package banking;

import banking.ui.BankFrm;
import framework.FinCo;

import java.util.ArrayList;
import java.util.List;

public class Bank extends FinCo {

    public Bank () {
        super();
    }

    public void run() {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                main = new BankFrm(Bank.this);
                main.setVisible(true);
            }
        });
    }

    public static void main(String[] args) {
        Bank creditCard = new Bank();
        creditCard.run();
    }

}
