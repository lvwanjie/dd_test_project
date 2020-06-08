package com.example.myapplication.binder.aidl_create;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;

import com.example.myapplication.Book;

public class Proxy implements IBookManagerAIDL {
    private IBinder mRemote;

    Proxy(IBinder remote) {
        mRemote = remote;
    }

    @Override
    public IBinder asBinder() {
        return mRemote;
    }

    public String getInterfaceDescriptor() {
        return Stub.DESCRIPTOR;
    }

    @Override
    public java.util.List<Book> getBookList() throws RemoteException {
        Parcel _data = Parcel.obtain();
        Parcel _reply = Parcel.obtain();
        java.util.List<Book> _result;
        try {
            _data.writeInterfaceToken(Stub.DESCRIPTOR);
            mRemote.transact(Stub.TRANSACTION_getBookList, _data, _reply, 0);
            _reply.readException();
            _result = _reply.createTypedArrayList(Book.CREATOR);
        } finally {
            _reply.recycle();
            _data.recycle();
        }
        return _result;
    }

    @Override
    public void addBook(Book book) throws RemoteException {
        Parcel _data = Parcel.obtain();
        Parcel _reply = Parcel.obtain();
        try {
            _data.writeInterfaceToken(Stub.DESCRIPTOR);
            if ((book != null)) {
                _data.writeInt(1);
                book.writeToParcel(_data, 0);
            } else {
                _data.writeInt(0);
            }
            mRemote.transact(Stub.TRANSACTION_addBook, _data, _reply, 0);
            _reply.readException();
        } finally {
            _reply.recycle();
            _data.recycle();
        }
    }
}

