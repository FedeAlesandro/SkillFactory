package org.example.models;

import org.example.exceptions.NotFundsExceptions;

public class BankAccount {

    private String accountNumber;
    private Double balance;

    public BankAccount(String accountNumber) {
        this.accountNumber = accountNumber;
        this.balance = 500000d;
    }

    // Hice el get y el set synchronized porque puede ser que un hilo quiera hacer un get y cuando lo haga otro modifique el valor,
    // entonces vas a trabajar con un dato no actualizado.
    public synchronized Double getBalance(){
        return balance;
    }
    public synchronized void setBalance(Double balance){
        this.balance = balance;
    }
    public synchronized void check(Double amount) throws NotFundsExceptions {
        if(getBalance()<amount)
            throw new NotFundsExceptions("You can not withdraw that amount because you do not have enough funds");
    }
    public synchronized void deposit(Double amount){
        setBalance(getBalance()+amount);
    }
    public synchronized Double withdraw(Double amount) throws NotFundsExceptions {
        this.check(amount);
        setBalance(getBalance()-amount);
        return amount;
    }
}
