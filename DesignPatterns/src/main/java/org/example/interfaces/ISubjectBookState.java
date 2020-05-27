package org.example.interfaces;

public interface ISubjectBookState {

    void attach(IBookBadState observer);
    void detach(IBookBadState observer);
    void notifyObservers();
}
