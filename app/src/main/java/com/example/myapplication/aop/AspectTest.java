package com.example.myapplication.aop;

import android.util.Log;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class AspectTest {

    final String TAG = AspectTest.class.getSimpleName();

    @Pointcut("execution(* android.app.Activity.on**(..))")
    public void executionActivityOn(){

    }

    @Before("executionActivityOn()")
    public void executionActivityOnBefore(JoinPoint joinPoint){
        Log.d(TAG, "executionActivityOnBefore: ");
    }
}
