package com.example.myapplication.designpattern.proxy;

public class ReflexUtils {

    public void getMethod(Class clz,String method,Class... params){
        try {
            clz.getDeclaredMethod(method,params);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
    }
}
