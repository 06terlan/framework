package framework.account;


import framework.party.Party;

public interface IAccount {

    public double getBalance();
    public void depositMoney(double money);
    public void withdrawMoney(double money);
    public Party getOwner();
    public void report();
    public void addInterest();
}
