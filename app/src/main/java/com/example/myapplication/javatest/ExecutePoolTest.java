package com.example.myapplication.javatest;

import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class ExecutePoolTest {

    private static final int COUNT_BITS = Integer.SIZE - 3;
    private static final int CAPACITY   = (1 << COUNT_BITS) - 1; //11111111111111111111111111111 29个1

    // runState is stored in the high-order bits
    private static final int RUNNING    = -1 << COUNT_BITS;      //-100000000000000000000000000000   29个0
    private static final int SHUTDOWN   =  0 << COUNT_BITS;
    private static final int STOP       =  1 << COUNT_BITS;      //100000000000000000000000000000 29个0
    private static final int TIDYING    =  2 << COUNT_BITS;      //1000000000000000000000000000000 30个0
    private static final int TERMINATED =  3 << COUNT_BITS;      //1100000000000000000000000000000 29个0
    private static final int fCAPACITY =  ~CAPACITY;             //-100000000000000000000000000000 29个0
    public static void main(String args[]){

        System.out.println(COUNT_BITS);
        System.out.println(CAPACITY);
        System.out.println(RUNNING);
        System.out.println(SHUTDOWN);
        System.out.println(STOP);
        System.out.println(TIDYING);
        System.out.println(TERMINATED);
        System.out.println((fCAPACITY));


    }

    public void startT(){
        Executors.newCachedThreadPool();

                ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(0,
                10,15, TimeUnit.MILLISECONDS,null,null,null);
                new ThreadPoolExecutor(0,10,15,TimeUnit.MILLISECONDS,null);
        threadPoolExecutor.execute(new Runnable() {
            @Override
            public void run() {

            }
        });


    }
}
