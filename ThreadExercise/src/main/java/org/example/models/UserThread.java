package org.example.models;

import org.example.exceptions.NotFundsExceptions;

public class UserThread implements Runnable{

    private Double deposit;
    private Double withdraw;
    private BankAccount bankAccount;

    public UserThread(Double deposit, Double withdraw, BankAccount bankAccount) {
        this.deposit = deposit;
        this.withdraw = withdraw;
        this.bankAccount = bankAccount;
    }

    @Override
    public void run() {
        bankAccount.deposit(deposit);
        try {
            bankAccount.withdraw(withdraw);
        } catch (NotFundsExceptions notFundsExceptions) {
            notFundsExceptions.printStackTrace();
        }
    }
}
