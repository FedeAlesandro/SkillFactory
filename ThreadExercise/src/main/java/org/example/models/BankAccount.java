package org.example.models;

import org.example.exceptions.MakeBalanceException;
import org.example.exceptions.NotFundsException;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class BankAccount {

    private String accountNumber;
    private Double balance;
    private List<LocalDateTime> contabilityDates;

    public BankAccount(String accountNumber) {
        this.accountNumber = accountNumber;
        this.balance = 500000d;
        this.contabilityDates = new ArrayList<>();
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public List<LocalDateTime> getContabilityDates() {
        return contabilityDates;
    }

    public synchronized Double getBalance() throws MakeBalanceException, InterruptedException {
        if(Thread.currentThread().getName().equals("BankManager")){
            Integer i=0;
            for(LocalDateTime localDateTime : contabilityDates){
                if(localDateTime.toLocalDate().equals(LocalDate.now()))
                    i++;
            }
            if(i<4){
                contabilityDates.add(LocalDateTime.now());
                wait(10000);
                notifyAll();
                return balance;
            }else
                throw new MakeBalanceException("You can't do more than 4 balance in a day");
        }
        return balance;
    }
    public synchronized void setBalance(Double balance){
        this.balance = balance;
    }
    public synchronized void check(Double amount) throws NotFundsException, MakeBalanceException, InterruptedException {
        if(getBalance()<amount)
            throw new NotFundsException("You can not withdraw that amount because you do not have enough funds");
    }
    public synchronized void deposit(Double amount) throws MakeBalanceException, InterruptedException {
        setBalance(getBalance()+amount);
    }
    public synchronized Double withdraw(Double amount) throws NotFundsException, MakeBalanceException, InterruptedException {
        this.check(amount);
        setBalance(getBalance()-amount);
        return amount;
    }
}
