package com.example.myapplication.binder;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

import androidx.annotation.NonNull;


import java.util.List;


public abstract class Stub extends Binder implements IInterface,IBookManager {

    public static final int TRANSACTION_getBookList = Binder.FIRST_CALL_TRANSACTION+0;
    public static final int TRANSACTION_addBook = Binder.FIRST_CALL_TRANSACTION+1;


    public Stub(){
       attachInterface(this,DESCRIPTOR);
    }

    @Override
    public IBinder asBinder() {
        return this;
    }


    //todo Parcel
    @Override
    protected boolean onTransact(int code, @NonNull Parcel data,  Parcel reply, int flags) throws RemoteException {
        switch (code){
            case TRANSACTION_getBookList:
                List<Book> list = this.getBookList();
                reply.writeNoException();
                reply.writeTypedList(list);
                return  true;
            case TRANSACTION_addBook:
                Book book;
                if(data.readInt() != 0){
                    book = Book.CREATOR.createFromParcel(data);
                }else {
                    book = null;
                }
                this.addBook(book);
                return  true;

        }
        return super.onTransact(code, data, reply, flags);
    }

    public void stub1(){

    }



}
