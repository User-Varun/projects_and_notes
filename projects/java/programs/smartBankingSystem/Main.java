package smartBankingSystem;

import smartBankingSystem.accounts.Account;

public class Main {
    public static void main(String[] args) {
        

        Bank b1 = new Bank("farzi bank");


        b1.addAccount(new SavingsAccount(1, "varun"));
        b1.addAccount(new CheckingAccount(2, "manisha"));
        
        System.out.println(b1.getAllAccounts());

        System.out.println(b1.findAccount(2));
        System.out.println(b1.findAccount(0));
        
    }
}


class SavingsAccount extends Account {

    SavingsAccount(int accountNumber , String holderName){
        super(accountNumber , holderName);
    }

    public double calculateInterest() {
        double interest  = getBalance() * 0.04 * 1;
        return interest;
    }
}


class CheckingAccount extends Account{

    CheckingAccount(int accountNumber , String holderName){
        super(accountNumber, holderName);
    }

    public double calculateInterest(){
        return 0.0;
    }
}