package smartBankingSystem;

import java.util.ArrayList;

import smartBankingSystem.accounts.Account;

public class Bank {
    private String name;
    private ArrayList<Account> accounts;


    public Bank(String name){
        this.name = name;
        this.accounts = new ArrayList<>();
    }

    public void addAccount(Account Acc){
       accounts.add(Acc);
       System.out.println("Added account successfully");
    }

    public ArrayList<Account> getAllAccounts(){
        return accounts;
    }

    public Account findAccount(int accountNumber){
        for(Account a : accounts){
            if(a.getAccountNumber() == accountNumber) return a;
        }

        return null;
    }
    public String getName(){
        return name;
    }
}
