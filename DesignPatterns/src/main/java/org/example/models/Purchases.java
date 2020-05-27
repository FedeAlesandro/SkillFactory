package org.example.models;

import org.example.enums.BookState;
import org.example.interfaces.IBookBadState;

public class Purchases implements IBookBadState {

    private BookAlarm bookAlarm;

    public Purchases(BookAlarm bookAlarm){
        this.bookAlarm=bookAlarm;
        bookAlarm.attach(this);
    }

    @Override
    public void update() {
        System.out.println("Change the price of this book.");
    }
}
