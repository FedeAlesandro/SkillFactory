package org.example.models;

import org.example.enums.BookState;

public class Book {

    private String name;
    private BookState bookState;

    public Book (String name){
        this.name=name;
        bookState=BookState.good;
    }

    public BookState getBookState() {
        return bookState;
    }

    public void setBookState(BookState bookState) {
        this.bookState = bookState;
    }

    @Override
    public String toString() {
        return "Book{" +
                "name='" + name + '\'' +
                ", bookState=" + bookState +
                '}';
    }
}
