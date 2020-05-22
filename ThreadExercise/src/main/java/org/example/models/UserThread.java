package org.example.models;

import org.example.exceptions.MakeBalanceException;
import org.example.exceptions.NotFundsException;

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
        try {
            bankAccount.deposit(deposit);
        } catch (MakeBalanceException | InterruptedException e) {
            e.printStackTrace();
        }
        try {
            bankAccount.withdraw(withdraw);
        } catch (NotFundsException | MakeBalanceException | InterruptedException notFundsException) {
            notFundsException.printStackTrace();
        }
    }
}
