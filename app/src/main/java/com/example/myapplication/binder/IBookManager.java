package com.example.myapplication.binder;

import java.util.List;

public interface IBookManager {

    static final String DESCRIPTOR = "com.example.myapplication.IBookManagerAIDL";

    void addBook(Book book);

    List<Book> getBookList();
}
