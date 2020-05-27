package org.example.models;

import org.example.enums.BookState;
import org.example.interfaces.IBookBadState;
import org.example.interfaces.ISubjectBookState;

import java.util.ArrayList;
import java.util.List;

public class BookAlarm implements ISubjectBookState {

    private List<IBookBadState>observers;
    private BookState state;

    public BookAlarm() {
        this.observers = new ArrayList<>();
    }

    public void setState(BookState state) {
        this.state = state;
        notifyObservers();
    }

    @Override
    public void attach(IBookBadState observer) {
        observers.add(observer);
    }

    @Override
    public void detach(IBookBadState observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers() {
        observers.forEach(IBookBadState::update);
    }
}
