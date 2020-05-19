package org.example;

import org.example.models.BankAccount;
import org.example.models.UserThread;

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
    }
}
