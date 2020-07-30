package com.example.myapplication.javatest;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

public class TestArrayList {

    public static void main(String[] args){
        ArrayList arrayList = new ArrayList();
        Object o = new Object();
        arrayList.add(o);
        if(!arrayList.contains(o)){
            arrayList.add(o);
        }
        System.out.println("");

        int a= 10/-1;
        int b = Math.abs(0);
        double c = (double)10/(double) 3;
        System.out.println(""+a+";b="+b +";c="+c);

        ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap();
        AtomicInteger integer = new AtomicInteger();
        int d = integer.incrementAndGet();
        int f = integer.decrementAndGet();
        integer.getAndDecrement();
//        integer.getAndAdd()



    }
}
