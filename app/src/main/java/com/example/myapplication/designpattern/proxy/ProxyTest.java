package com.example.myapplication.designpattern.proxy;

//代理模式使用场景
// 1、

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

import dalvik.system.DexClassLoader;

public class ProxyTest {

    public static void main(String args[]){
        getSingleProxy();
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

        proxy.sing();
        proxy.dance();
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




