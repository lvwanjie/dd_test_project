package com.example.myapplication.fitTest;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

public class JavaTest {

    public static void main(String args[]){
        reflexEntity();
    }


    public static void reflexEntity(){
        Class clz = Entity.class;
        Field field[] = clz.getFields();
        Field dField[] = clz.getDeclaredFields();
        String s =  dField[2].getName();
        int m = dField[2].getModifiers();
        boolean isStaic =  Modifier.isStatic(m);
        try {
            String entityClz = (String) dField[2].get(clz);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        System.out.println("");
    }
}
