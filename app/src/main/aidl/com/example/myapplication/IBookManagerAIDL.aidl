// IBookManagerAIDL.aidl
package com.example.myapplication;
import com.example.myapplication.Book;

// Declare any non-default types here with import statements

interface IBookManagerAIDL {



        List<Book> getBookList();

        void addBook(in Book book);
}
