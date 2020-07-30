package com.example.myapplication.fanxing.myGroup.people;

public class List {

    private Object[] o = {new Student(),new Man()};

    public <T extends Man>T get(int i){
        return (T) o[i];
    }
}
