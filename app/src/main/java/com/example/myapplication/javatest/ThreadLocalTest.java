package com.example.myapplication.javatest;

import android.os.Looper;

public class ThreadLocalTest {



    public static void main(String args[]){

        Object object = new Object();
        Thread1 thread1 =new Thread1(object);
        Thread2 thread2 =new Thread2(object);

    }


    public void testThreadLocal(){
        ThreadLocal threadLocal= new ThreadLocal();
        threadLocal.get();
        Looper.prepare();
        threadLocal.set("");
        threadLocal.get();
    }



    public static class Thread1 extends Thread{

        private Object object;
        private ThreadLocal threadLocal;
        public Thread1(Object object){
            this.object = object;
            threadLocal = new ThreadLocal();
        }

        @Override
        public void run() {
            super.run();
            threadLocal.set(object);
        }
    }

    public static class Thread2 extends Thread{

        private Object object;
        private ThreadLocal threadLocal;
        public Thread2(Object object){
            this.object = object;
            threadLocal = new ThreadLocal();
        }
        @Override
        public void run() {
            super.run();
            threadLocal.set(object);
        }
    }
}
