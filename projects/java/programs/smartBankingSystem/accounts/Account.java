package smartBankingSystem.accounts;

public abstract class Account {
    private int accountNumber;
    private String holderName;
    private double balance;

    public Account(int accountNumber, String holderName) {
        this.accountNumber = accountNumber;
        this.holderName = holderName;
    };

    public void deposit(int amount) {

        if (amount <= 0)
            throw new IllegalArgumentException("invalid amount");

        balance += amount;
    }

   
    public void withdraw(int amount) {

        if (this.balance < amount)
            throw new IllegalArgumentException("invalid withdrawl amount");

        balance -= amount;
    }


    protected double getBalance() {
        return balance;
    }

    public int getAccountNumber(){
        return accountNumber;
    }

    public abstract double calculateInterest();

    @Override
    public String toString(){
        return "Account Number : " + accountNumber + ", Holder: " + holderName + ", Balance: " + balance;
    }
}
