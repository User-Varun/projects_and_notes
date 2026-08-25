/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.varun.practicingwritinginjava;


/**
 *
 * @author Varun
 */
public class BankAccount {

    private double balance;
    private final String accountNumber;

    // generate 10 digit ( number and char ) acc no. 
    private String generateAccNo() {
        int[] nums = {1, 2, 3, 4, 5};
        char[] alphabet = {'A', 'B', 'C', 'D', 'E'};
        String[] accNoArr = new String[10];

        // choose 5 unit from each array randomly
        for (int i = 0; i < 5; i++) {

            int ran1 = (int) (Math.random() * 5); // 1 to 4

            accNoArr[i] = String.valueOf(alphabet[ran1]);

        }

        for (int j = 5; j < 10; j++) {
            int ran2 = (int) (Math.random() * 5); // 1 to 4
            accNoArr[j] = String.valueOf(nums[ran2]);
        }

        StringBuilder sb = new StringBuilder();

        for (String s : accNoArr) {
            sb.append(s);
        }

        return sb.toString();
    }

    // can only be access ( in this package)
    BankAccount(double initialBalance) {
        this.balance = initialBalance;
        this.accountNumber = generateAccNo();

    }

    public String getAccountNumber() {
        System.out.println(accountNumber);

        return accountNumber;
    }

    public void getBalance() {
        System.out.println(balance);
    }

  
    public void deposit(double b) {
        
        if(b <= 0 ) return;
        
        this.balance += b;
    }

    public void withdraw(double amount) {
        if (amount <= 0) {
            return;
        }

        if (amount > balance) {
            return;
        }

        this.balance -= amount;

    }
}
