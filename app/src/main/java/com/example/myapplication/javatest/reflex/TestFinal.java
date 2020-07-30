package com.example.myapplication.javatest.reflex;

import androidx.annotation.Nullable;

public class TestFinal {

    public final String a = "好合好散";

    private final String b;

    public TestFinal(){
        b = "好啊";
    }

    public String getA(){
        return a;
    }

    public String ddcA(){
        return a;
    }

    public String getB(){
        return b;
    }

    public String ddcB(){
        return b;
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(@Nullable Object obj) {
        return super.equals(obj);
    }
}
