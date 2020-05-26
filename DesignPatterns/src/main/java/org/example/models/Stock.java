package org.example.models;

import org.example.enums.BookState;
import org.example.interfaces.IBookBadState;

public class Stock implements IBookBadState {

    private BookAlarm bookAlarm;

    public Stock(BookAlarm bookAlarm){
        this.bookAlarm=bookAlarm;
        bookAlarm.attach(this);
    }

    @Override
    public void update() {
        System.out.println("Remove this book.");
    }
}
