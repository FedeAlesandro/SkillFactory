package org.example;

import org.example.models.BankAccount;
import org.example.models.BankManager;
import org.example.models.UserThread;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class App 
{
    public static void main( String[] args )
    {
        BankAccount bankAccount = new BankAccount("1234");
        Thread userThread1 = new Thread(new UserThread(10000d, 125000d, bankAccount));
        userThread1.start();
        Thread userThread2 = new Thread(new UserThread(12000d, 200000d, bankAccount));
        userThread2.start();
        try {
            Thread.sleep(50);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(bankAccount.getBalance());

        ExecutorService executorService = Executors.newFixedThreadPool(1); //Preg newSingleThreadExecutor vs newFixedThreadPool(1)
        Future<Double> balance = executorService.submit(new BankManager(bankAccount));
        executorService.shutdown();
        try {
            System.out.println(balance.get());
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
    }
}
