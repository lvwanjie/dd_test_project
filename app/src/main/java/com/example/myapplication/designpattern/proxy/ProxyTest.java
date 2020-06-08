package com.example.myapplication.designpattern.proxy;

//代理模式使用场景
// 1、

import android.annotation.TargetApi;
import android.os.Build;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

import dalvik.system.DexClassLoader;

public class ProxyTest {

    public static void main(String args[]){
//        getSingleProxy();
        getMySingleProxy();
    }


    public static  void getSingleProxy(){
        ClassLoader classLoader;
        ClassLoader.getSystemClassLoader();

        final Singler singler = new Singler();
        ClassLoader loader = singler.getClass().getClassLoader();
        Class a[] = singler.getClass().getInterfaces();
        ISing proxy = (ISing) Proxy.newProxyInstance(singler.getClass().getClassLoader(), singler.getClass().getInterfaces(), new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                System.out.println("唱歌前");
                Object ob = method.invoke(singler,args);
                System.out.println("唱歌后");
                return  ob;
            }
        });

        SingleProxy singleProxy = new SingleProxy(singler);
        ISing proxy1 = (ISing) Proxy.newProxyInstance(singler.getClass().getClassLoader(), singler.getClass().getInterfaces(),singleProxy);
        proxy1.sing();
        proxy1.dance();
        proxy.sing();
        proxy.dance();
    }


    @TargetApi(Build.VERSION_CODES.N)
    public static void getMySingleProxy(){
        Singler singler = new Singler();
        SingleProxy singleProxy = new SingleProxy(singler);
        ISing proxy = (ISing) com.example.myapplication.designpattern.proxy.Proxy.
                newProxyInstance(singler.getClass().getClassLoader(),singler.getClass().getInterfaces(),singleProxy);

        proxy.dance();
        proxy.sing();
    }


    public static class SingleProxy implements InvocationHandler {

        public SingleProxy(){

        }

        private ISing sing;
        public SingleProxy(ISing sing){
            this.sing = sing;
        }
        @Override
        public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
            System.out.println("唱歌前");
            Singler singler = new Singler();
            Object ob = method.invoke(singler,args);
            System.out.println("唱歌后");
            return  false;
        }
    }








    public class A{

        public void doSomething(){

        }
    }


    public class B{
        private A a;
        public B(A a){
            this.a = a;
        }
        public void doSomething(){
            a.doSomething();
        }
    }

}




