package com.example.myapplication.javatest.threadTest;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class LockTest {

    private ReentrantLock lock = new ReentrantLock();
    private Condition condition1 = lock.newCondition();
    private Condition condition2 = lock.newCondition();
    private Condition condition3 = lock.newCondition();

    public static void main(String args[]){
        Thread1  thread1 = new Thread1();
        Thread2 thread2 = new Thread2();
        Thread3 thread3 = new Thread3();
        LockTest lockTest = new LockTest();
        thread1.setObject(lockTest);
        thread2.setObject(lockTest);
        thread3.setObject(lockTest);
        thread1.start();
        thread2.start();
        thread3.start();
    }

    public synchronized void doSomething1(){
        try {
            System.out.println(Thread.currentThread()+";time="+System.currentTimeMillis()/1000+"method=doSomething1");
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


    public void doSomething2(){

        try {
            lock.lock();
            System.out.println(Thread.currentThread()+";time="+System.currentTimeMillis()/1000+"method=doSomething2");
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }

    /**
     * 两个线程交替打印
     */
    private int count = 0 ;
    public synchronized void doSomething3(){
        try {
            while (count <1000){
                notifyAll();
                System.out.println(Thread.currentThread()+";time="+System.currentTimeMillis()/1000+"method=doSomething3");
                System.out.println(count+"");
                count++;
                wait();
            }

        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            //只要有一个线程走完 就算结束
            notifyAll();
        }
    }


    public void doSomething4(){

        lock.lock();
        while (count<100){
            System.out.println(Thread.currentThread()+";time="+System.currentTimeMillis()/1000+"method=doSomething3");
            System.out.println(count+"");

        }

        lock.unlock();
    }


    /**
     *
     */
    public void testAwait1(){
        try {
            while (count<100){
                lock.lock();
                condition2.signal();
                System.out.println(count);
                System.out.println(Thread.currentThread()+";time="+System.currentTimeMillis()/1000+"method=testAwait1");
                count ++;
                condition1.await();
            }

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void testAwait2(){
        try {
            while (count<100){
                lock.lock();
                condition3.signal();
                System.out.println(count);
                System.out.println(Thread.currentThread()+";time="+System.currentTimeMillis()/1000+"method=testAwait2");
                count ++;
                condition2.await();
            }

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void testAwait3(){
        try {
            while (count<100){
                lock.lock();
                condition1.signal();
                System.out.println(count);
                System.out.println(Thread.currentThread()+";time="+System.currentTimeMillis()/1000+"method=testAwait3");
                count ++;
                condition3.await();
            }

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }






}
