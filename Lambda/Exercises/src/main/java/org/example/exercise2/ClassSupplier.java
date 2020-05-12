package org.example.exercise2;


import java.time.LocalDateTime;
import java.util.function.Supplier;

public class ClassSupplier {
    //private LocalDateTime date; no tiene sentido

    public ClassSupplier(){

    }
    public LocalDateTime getDate() {
        Supplier<LocalDateTime>supplierDate = LocalDateTime::now;
        return supplierDate.get();
    }
}
