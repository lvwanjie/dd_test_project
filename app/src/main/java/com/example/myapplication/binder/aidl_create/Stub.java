/*
 * This file is auto-generated.  DO NOT MODIFY.
 * Original file: /Users/gaoxiuyang/AndroidStudioProjects/dd_test_project/app/src/main/aidl/com/example/myapplication/IBookManagerAIDL.aidl
 */
package com.example.myapplication.binder.aidl_create;
// Declare any non-default types here with import statements

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

import com.example.myapplication.Book;

import java.util.List;

/**
 * Local-side IPC implementation stub class.
 */
public abstract class Stub extends Binder implements IBookManagerAIDL {
    public static final String DESCRIPTOR = "com.example.myapplication.IBookManagerAIDL";

    public static final int TRANSACTION_getBookList = (IBinder.FIRST_CALL_TRANSACTION + 0);
    public static final int TRANSACTION_addBook = (IBinder.FIRST_CALL_TRANSACTION + 1);
    /**
     * Construct the stub at attach it to the interface.
     */
    public Stub() {
        this.attachInterface(this, DESCRIPTOR);
    }

    /**
     * Cast an IBinder object into an com.example.myapplication.IBookManagerAIDL interface,
     * generating a proxy if needed.
     */
    public static IBookManagerAIDL asInterface(IBinder obj) {
        if ((obj == null)) {
            return null;
        }
        IInterface iin = obj.queryLocalInterface(DESCRIPTOR);
        if (((iin != null) && (iin instanceof IBookManagerAIDL))) {
            return (IBookManagerAIDL)iin;
        }
        return new Proxy(obj);
    }

    @Override
    public IBinder asBinder() {
        return this;
    }

    @Override
    public boolean onTransact(int code, Parcel data, Parcel reply, int flags) throws RemoteException {
        String descriptor = DESCRIPTOR;
        switch (code) {
            case INTERFACE_TRANSACTION: {
                reply.writeString(descriptor);
                return true;
            }
            case TRANSACTION_getBookList: {
                data.enforceInterface(descriptor);
                List<Book> _result = this.getBookList();
                reply.writeNoException();
                reply.writeTypedList(_result);
                return true;
            }
            case TRANSACTION_addBook: {
                data.enforceInterface(descriptor);
                Book _arg0;
                if ((0 != data.readInt())) {
                    _arg0 = Book.CREATOR.createFromParcel(data);
                } else {
                    _arg0 = null;
                }
                this.addBook(_arg0);
                reply.writeNoException();
                return true;
            }
            default: {
                return super.onTransact(code, data, reply, flags);
            }
        }
    }



}


