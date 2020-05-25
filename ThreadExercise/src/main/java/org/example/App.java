package org.example;

import org.example.exceptions.MakeBalanceException;
import org.example.models.BankAccount;
import org.example.models.BankManager;
import org.example.models.UserThread;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

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

        ExecutorService service = Executors.newFixedThreadPool(2);
        // Exercise 6
        Runnable runnableWorker = () ->{
            for(int i = 0; i<10; i++)
                System.out.println("Hello Im a runnable worker, i:" + i);
        };
        Callable<String> stringCallable = () -> "Me llamo string callable";
        Callable<Integer> integerCallable = () -> 20;
        Runnable runnableWorker2 = () -> System.out.println("Hola soy un trabajador runnable");

        service.execute(runnableWorker);

        Future<String>stringFuture = service.submit(stringCallable);
        try {
            System.out.println("Future of string: " + stringFuture.get());
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }

        Future<Integer>integerFuture = service.submit(integerCallable);
        try {
            System.out.println("Future of integer: " + integerFuture.get());
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }

        service.execute(runnableWorker2);

        // 6) bis
        /*
            No supe como hacer exactamente lo de esperar a una tarea en especifico, esperar a una tarea en particular cuando utilizabamos
            colección de tareas (lo más parecido que encontre fue invokeAny pero como que retorna el resultado de una tarea cualquiera que este en la colección
            por lo que entendí) y lo de obtener los resultados a medida que las tareas se completan. Yo interprete que sería se hace una tarea y acto seguido se muestra,
            después otra tarea y así. Trate de hacer lo más parecido pero creo que no es eso lo que se pide.
         */
        List<Callable<String>>tasks = Arrays.asList(
                ()->"hola",
                ()->"soy",
                ()->"un arreglo",
                ()->"de callables"
        );

        try {
            List<Future<String>> responses = service.invokeAll(tasks);
            responses.forEach(a -> {
                        try {
                            System.out.println(a.get());
                        } catch (InterruptedException | ExecutionException e) {
                            e.printStackTrace();
                        }
                    });
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


        // Exercise7

        CompletableFuture.runAsync(()-> System.out.println("Hello Im a runnable worker in completable future"));

        // *PREGUNTA* Debería ser así:
        /*CompletableFuture<String>completableFuture = CompletableFuture.supplyAsync(() -> {
            String string = "";
            try{
                string = stringCallable.call();
            } catch (Exception e) {
                e.printStackTrace();
            }
            return string;
        });*/

        // o asi? (para mi tiene más sentido así):
        CompletableFuture<String>stringCompletableFuture = CompletableFuture.supplyAsync(() -> "Me llamo string callable");
        try {
            System.out.println("CompletableFuture of string: " + stringCompletableFuture.get());
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }

        CompletableFuture<Integer>integerCompletableFuture = CompletableFuture.supplyAsync(()-> 20);
        try {
            System.out.println("CompletableFuture of integer: " + integerCompletableFuture.get());
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
        CompletableFuture.runAsync(()-> System.out.println("Hola soy un trabajador runnable"));

        stringCompletableFuture
                .thenRun(() -> System.out.println("String completable future finished"));

        try {
            System.out.println(
                    "Sum number" +
                    integerCompletableFuture
                    .thenApply(x -> x + 10)
                    .get());
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }

        service.shutdown();
        try {
            service.awaitTermination(5L, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
