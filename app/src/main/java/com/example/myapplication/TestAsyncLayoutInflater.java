package com.example.myapplication;

import androidx.asynclayoutinflater.view.AsyncLayoutInflater;

import com.example.mylibrary.TestMaven;

import java.util.TreeMap;

/**
 * 两个线程交替打印数字
 */
public class TestAsyncLayoutInflater {

    private int i;
    public static void main(String args[]){
        TestAsyncLayoutInflater testAsyncLayoutInflater = new TestAsyncLayoutInflater();
        new Thread1(testAsyncLayoutInflater).start();
        new Thread2(testAsyncLayoutInflater).start();
        TestMaven.doSometing();
    }


    public synchronized void getNum(){
        System.out.println("abcd");
        try {
            for(;i<100;){
                notify();
                System.out.println(i+",currentThread="+Thread.currentThread());
                i++;
                wait();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("efg");
    }

    public static class Thread1 extends Thread{
        private TestAsyncLayoutInflater testAsyncLayoutInflater;
        public Thread1(TestAsyncLayoutInflater testAsyncLayoutInflater){
            this.testAsyncLayoutInflater = testAsyncLayoutInflater;
        }
        @Override
        public void run() {
            testAsyncLayoutInflater.getNum();
        }
    }
    public static class Thread2 extends Thread{
        private TestAsyncLayoutInflater testAsyncLayoutInflater;
        public Thread2(TestAsyncLayoutInflater testAsyncLayoutInflater){
            this.testAsyncLayoutInflater = testAsyncLayoutInflater;
        }
        @Override
        public void run() {
            testAsyncLayoutInflater.getNum();
        }
    }
}
