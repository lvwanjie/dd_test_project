package com.example.myapplication.javatest.reflex;

import androidx.recyclerview.widget.RecyclerView;

import java.lang.reflect.Field;

public class ReflexTest {

    public static void main(String args[]){
        Class pClz = Person.class;
        try {
            Field field = pClz.getDeclaredField("name");
            field.setAccessible(true);
            field.set(pClz,"abc");
            Field field1 = pClz.getDeclaredField("name");
            String str = (String) field.get(pClz);
            RecyclerView recyclerView;
//            recyclerView.
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }

    }
}
