package com.example.myapplication.javatest.threadTest;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class ThreadPoolTest {


    public static void main(String[] args){

//        test();

        test2();
    }

    public static void test(){
        ThreadPoolExecutor executor  =new ThreadPoolExecutor(0,2,1000, TimeUnit.MILLISECONDS,new LinkedBlockingDeque<Runnable>());
        executor.execute(new Runnable() {
            @Override
            public void run() {

                System.out.println("run"+Thread.currentThread().getName());

            }
        });

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        executor.execute(new Runnable() {
            @Override
            public void run() {
                System.out.println("run22222"+Thread.currentThread().getName());
            }
        });

    }


    public static void test2(){
       Executor executor =  Executors.newSingleThreadExecutor();
       Executors.newCachedThreadPool();
       Executors.newFixedThreadPool(3);
       Executors.newScheduledThreadPool(3);
       Executors.newSingleThreadScheduledExecutor();
       executor.execute(new Runnable() {
           @Override
           public void run() {
               System.out.println("run"+Thread.currentThread().getName());
           }
       });
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        executor.execute(new Runnable() {
            @Override
            public void run() {
                System.out.println("run2222"+Thread.currentThread().getName());
            }
        });

    }


    public static void test3(){

    }
}
