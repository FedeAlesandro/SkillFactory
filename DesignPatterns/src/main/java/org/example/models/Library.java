package org.example.models;

import org.example.enums.BookState;

import java.util.HashSet;
import java.util.Set;

public class Library {

    private String name;
    private Set <Book> books; // I know that a library can have more than one book repeated in the real life
    private BookAlarm bookAlarm;

    public Library(String name) {
        this.name = name;
        this.books = new HashSet<>();
        this.bookAlarm = new BookAlarm();
    }

    public Set<Book> getBooks() {
        return books;
    }

    public void addBook(Book book){
        books.add(book);
    }

    public void lendBook(Book book){
        books.remove(book);
    }

    public Book receiveBook(Book book){
        if(book.getBookState().equals(BookState.bad))
        {
            new Administration(bookAlarm);
            new Purchases(bookAlarm);
            new Stock(bookAlarm);
            bookAlarm.setState(BookState.bad);
        }
        books.add(book);
        return book;
    }

}
