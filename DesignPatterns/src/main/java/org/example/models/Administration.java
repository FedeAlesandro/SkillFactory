package org.example.models;

import org.example.interfaces.IBookBadState;

public class Administration implements IBookBadState {

    private BookAlarm bookAlarm;

    public Administration(BookAlarm bookAlarm){
        this.bookAlarm=bookAlarm;
        bookAlarm.attach(this);
    }
    @Override
    public void update() {
        System.out.println("This book is in bad conditions!");

    }
}
