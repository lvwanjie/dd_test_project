package com.example.myapplication.aop;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.os.SystemClock;
import android.util.Log;

import com.example.myapplication.R;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;

import dalvik.system.DexClassLoader;
import dalvik.system.PathClassLoader;

import static androidx.constraintlayout.widget.Constraints.TAG;

@Aspect
public class AopTest extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_aop_test);
        long l = SystemClock.uptimeMillis();
        Log.i(TAG, "onCreate: l="+l);
//        DexClassLoader classLoader = new DexClassLoader();
//        PathClassLoader classLoader1 = new PathClassLoader();

    }


    @Pointcut("execution(* android.app.Activity.on**(..))")
    public void test(){
        System.out.println("test");
    }








}
