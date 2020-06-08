/*
 * This file is auto-generated.  DO NOT MODIFY.
 * Original file: /Users/gaoxiuyang/AndroidStudioProjects/dd_test_project/app/src/main/aidl/com/example/myapplication/IBookManagerAIDL.aidl
 */
package com.example.myapplication.binder.aidl_create;

import com.example.myapplication.Book;

import java.util.List;

public interface IBookManagerAIDL extends android.os.IInterface {

     List<Book> getBookList() throws android.os.RemoteException;

     void addBook(com.example.myapplication.Book book) throws android.os.RemoteException;
}
