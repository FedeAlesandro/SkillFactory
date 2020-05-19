package org.example.models;

import org.example.exceptions.NotFundsExceptions;

public class BankAccount {

    private String accountNumber;
    private Double balance;

    public BankAccount(String accountNumber) {
        this.accountNumber = accountNumber;
        this.balance = 500000d;
    }

    public Double getBalance(){
        return balance;
    }
    public void check(Double amount) throws NotFundsExceptions {
        if(balance<amount)
            throw new NotFundsExceptions("You can not withdraw that amount because you do not have enough funds");
    }
    public void deposit(Double amount){
        this.balance+=amount;
    }
    public Double withdraw(Double amount) throws NotFundsExceptions {
        this.check(amount);
        balance-=amount;
        return amount;
    }
}
