package com.example.myapplication.javatest.threadTest;

public class Thread2 extends Thread{

    private LockTest lockTest;

    public void setObject(LockTest lockTest){
        this.lockTest = lockTest;
    }
    @Override
    public void run() {
        super.run();
//        lockTest.doSomething3();
        lockTest.testAwait2();
    }
}
