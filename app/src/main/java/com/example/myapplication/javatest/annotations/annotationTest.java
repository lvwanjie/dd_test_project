package com.example.myapplication.javatest.annotations;

import android.util.LruCache;

import androidx.annotation.IntDef;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

public class annotationTest {

    public static final int LEVEL_0 =0;
    public static final int LEVEL_1 =1;

    @IntDef({LEVEL_0,LEVEL_1})
    @Retention(RetentionPolicy.SOURCE)
    public @interface PERF{

    }

    public static void main(String[] args){

        getLevel(LEVEL_0);


    }

    public static void getLevel(@PERF  int level){

    }
}
