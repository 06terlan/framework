package framework.account;


import framework.party.Party;

public interface IAccount {

    public double getBalance();
    public void depositMoney(double mooney);
    public Party getOwner();
    public void report();
    public void addInterest();
}
