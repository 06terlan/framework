package framework;

public abstract class Account implements IAccount {

    @Override
    public double getBalance() {
        return 0;
    }

    @Override
    public void addEntry() {

    }

    @Override
    public Party getOwner() {
        return null;
    }


}
