package banking;

import framework.Account;

public abstract class BankAccount extends Account {

    private double interest;

    public abstract void addInterest();

}
