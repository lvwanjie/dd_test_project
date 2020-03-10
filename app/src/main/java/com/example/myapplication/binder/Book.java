package com.example.myapplication.binder;

import android.os.Parcel;
import android.os.Parcelable;

public class Book implements Parcelable {

    public String name;

    public int price;

    public String author;

    protected Book(Parcel in) {
        name = in.readString();
        price = in.readInt();
        author = in.readString();
    }

    public static final Creator<Book> CREATOR = new Creator<Book>() {
        @Override
        public Book createFromParcel(Parcel in) {
            return new Book(in);
        }

        @Override
        public Book[] newArray(int size) {
            return new Book[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(name);
        dest.writeInt(price);
        dest.writeString(author);
    }

    public void addBook1(){

    }
}
