package com.example.myapplication.parcelable;

import android.os.Parcel;
import android.os.Parcelable;

public class TestEntity1 implements Parcelable {

    private String s;


    public TestEntity1(){

    }
    protected TestEntity1(Parcel in) {
        s = in.readString();
    }

    public static final Creator<TestEntity1> CREATOR = new Creator<TestEntity1>() {
        @Override
        public TestEntity1 createFromParcel(Parcel in) {
            return new TestEntity1(in);
        }

        @Override
        public TestEntity1[] newArray(int size) {
            return new TestEntity1[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(s);
    }
}
