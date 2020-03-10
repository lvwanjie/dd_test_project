package com.example.myapplication.binder;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import android.view.WindowManager;

import java.util.List;

public class Proxy implements IBookManager, IInterface {

    WindowManager windowManager;
    private IBinder mRemote;
    public Proxy(IBinder binder){
        this.mRemote = binder;
//        windowManager.addView();
    }
    @Override
    public void addBook(Book book) {
        Parcel data = Parcel.obtain();
        Parcel reply = Parcel.obtain();
        data.writeInterfaceToken(DESCRIPTOR);
        if(book != null){
            data.writeInt(1);
            book.writeToParcel(data,0);
        }else {
            data.writeInt(0);
        }
        boolean status = false;
        try {
            status = mRemote.transact(Stub.TRANSACTION_addBook,data,reply,0);
//            if(!status && getD)

        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Book> getBookList() {
        return null;
    }

    @Override
    public IBinder asBinder() {
        return mRemote;
    }

    public void testFunc1(){

    }


    public void testFunc2(){

    }
}
