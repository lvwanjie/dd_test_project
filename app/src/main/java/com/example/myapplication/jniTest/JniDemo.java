package com.example.myapplication.jniTest;

public class JniDemo {

    public native void print();

    public native int getSomething();

    public native void testHello();

    public static void main(String args[]){
        System.load("com_example_myapplication_jniTest_JniDemo");
        JniDemo jniDemo = new JniDemo();
        jniDemo.testHello();
    }
}
