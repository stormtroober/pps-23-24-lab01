package example.model;

public class SimpleBankAccountWithAtm extends SimpleBankAccount{

    private double fee;

    public SimpleBankAccountWithAtm(final AccountHolder holder, final double balance, final double fee){
        super(holder, balance);
        this.fee = fee;
    }

    @Override
    public void deposit(final int userId, final double amount){
        if(checkUser(userId)){
            super.balance += (amount - fee);
        }
    }
    
    @Override
    public void withdraw(final int userId, final double amount){
        if(checkUser(userId) && isWithdrawAllowed(amount)){
            super.balance -= (amount + fee);
        }
    }

    @Override
    protected boolean isWithdrawAllowed(final double amount){
        return super.balance >= amount + fee;
    }
}