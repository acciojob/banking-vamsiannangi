package com.driver;

public class BankAccount {

    private String name;
    private double balance;
    private double minBalance;

    public String getName() {
        return name;
    }

    public double getBalance() {
        return balance;
    }

    public double getMinBalance() {
        return minBalance;
    }

    public BankAccount(String name, double balance, double minBalance) {
        this.name = name;
        this.balance = balance;
        this.minBalance = minBalance;
    }

    public String generateAccountNumber(int digits, int sum) throws Exception{
        int rem = sum;
        String accNo = "";
        if(digits*9 < sum){
            throw new Exception("Account Number can not be generated");
        }
        else{
            while(digits > 0 && rem > 0){
                if(rem >= 9){
                    rem = rem - 9;
                    accNo = accNo + "9";
                }
                else{
                    accNo = accNo + Integer.toString(rem);
                    rem = 0;
                }
                digits--;
            }
            while(digits > 0){
                accNo = accNo + "0";
                digits--;
            }
            return accNo;
        }
    }

    public void deposit(double amount) {
        balance = balance + amount;

    }

    public void withdraw(double amount) throws Exception {
        if(this.balance-amount>=getMinBalance())
        {
            balance=balance-amount;
        }
        else {
            throw new Exception("Insufficient Balance");
        }
    }

}