package com.example.myapplication.javatest;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class OutClass {

    private String a;

    public OutClass(int a){

    }

    public OutClass(){
        System.gc();
        Runtime.getRuntime().gc();

    }

    public class innerClass extends OutClass{

        private String b;

        public innerClass(int a) {
            super(a);
        }

        public innerClass(){

        }

        public innerClass(String str){

        }
    }



    public static void main(String[] args){
        Class clz = OutClass.innerClass.class;
        try {
            Constructor[] c = clz.getConstructors();
           Object object =  clz.getConstructor().newInstance();
           System.out.println("");
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }
}
