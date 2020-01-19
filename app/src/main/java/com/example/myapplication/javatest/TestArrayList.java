package com.example.myapplication.javatest;

import java.util.ArrayList;

public class TestArrayList {

    public static void main(String[] args){
        ArrayList arrayList = new ArrayList();
        Object o = new Object();
        arrayList.add(o);
        if(!arrayList.contains(o)){
            arrayList.add(o);
        }
        System.out.println("");
    }
}
