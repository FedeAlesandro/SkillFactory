package org.example.models;

import java.util.concurrent.Callable;

public class BankManager implements Callable {

    private Double balance;
    private BankAccount bankAccount;

    public BankManager(BankAccount bankAccount) {
        this.bankAccount = bankAccount;
    }

    @Override
    public Object call() throws Exception {
        balance = bankAccount.getBalance();
        return this.balance;
    }
}
