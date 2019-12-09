package com.example.myapplication.fanxing;

public class Student<T extends Name> {

    T name ;

    T[] list;

    public  void  add(){
        list[0] = name;
    }

    public T getName(){
        return name;
    }
}
