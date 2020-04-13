package com.example.myapplication.javatest.threadTest;

import java.util.concurrent.locks.Lock;

public class Thread1 extends Thread{

    private LockTest lockTest;

    public void setObject(LockTest lockTest){
        this.lockTest = lockTest;
    }
    @Override
    public void run() {
        super.run();
//        lockTest.doSomething3();
        lockTest.testAwait1();
    }
}
