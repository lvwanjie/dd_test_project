package com.example.myapplication.jniTest;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.graphics.Canvas;

/**
 * 生成so库
 * gcc -shared -I /Applications/AndroidStudio.app/Contents/jre/jdk/Contents/Home/include -fPIC app/src/main/java/com/example/myapplication/jniTest/com_example_myapplication_jniTest_JniDemo.h -o libjni-test.so
 *
 * 生成.class
 *javac app/src/main/java/com/example/myapplication/jniTest/JniDemo.java
 *
 * 生成.h
 * javah com.example.myapplication.jniTest.JniDemo
 */

public class JniDemo {

    public native void print();

    public native int getSomething();

    public native void testHello();

    public static void main(String args[]){
        System.load("com_example_myapplication_jniTest_JniDemo");
        JniDemo jniDemo = new JniDemo();
        jniDemo.testHello();
        Canvas canvas;
//        ObjectAnimator animator = ObjectAnimator.ofFloat("","",);
//        animator.start();
    }
}
