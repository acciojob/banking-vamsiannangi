package com.driver;

public class SavingsAccount extends BankAccount{
    double rate;
    double maxWithdrawalLimit;

    public double getRate() {
        return rate;
    }

    public double getMaxWithdrawalLimit() {
        return maxWithdrawalLimit;
    }

    public SavingsAccount(String name, double balance, double maxWithdrawalLimit, double rate) {
        // minimum balance is 0 by default
        super(name,balance,0);
        this.rate = rate;
        this.maxWithdrawalLimit = maxWithdrawalLimit;

    }
    public void withdraw(double amount) throws Exception {
        if(amount <= maxWithdrawalLimit) {
            super.withdraw(amount);
        }
        else {
            throw new Exception("Maximum Withdraw Limit Exceeded");
        }

    }

    public double getSimpleInterest(int years){
        return getBalance()*(1 + (rate*years)/100);
    }

    public double getCompoundInterest(int times, int years){
        double compoundInterest = getBalance() * Math.pow((1 + rate / (100*times)), times * years);
        //  return compoundInterest;
        return compoundInterest;
    }

}