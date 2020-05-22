package org.example;

import org.example.exceptions.MakeBalanceException;
import org.example.models.BankAccount;
import org.example.models.BankManager;
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
        try {
            System.out.println(bankAccount.getBalance());
        } catch (MakeBalanceException | InterruptedException e) {
            e.printStackTrace();
        }
        Thread managerThread = new Thread(new BankManager(bankAccount));
        managerThread.start();

        //Im not sure that the 5) works fine, I dont understand very well if Im doing right

        
    }
}
