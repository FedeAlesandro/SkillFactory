package org.example.models;

import org.example.exceptions.MakeBalanceException;

public class BankManager implements Runnable {

    private BankAccount bankAccount;

    public BankManager(BankAccount bankAccount) {
        this.bankAccount = bankAccount;
    }

    @Override
    public void run() {
        Thread.currentThread().setName("BankManager");
        try {
            System.out.println(bankAccount.getBalance());
        } catch (MakeBalanceException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}
