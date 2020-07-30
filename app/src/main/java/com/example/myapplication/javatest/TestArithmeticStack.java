package com.example.myapplication.javatest;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * 测试运算时操作数栈
 *  使用指令
 * javac app/src/main/java/com/example/myapplication/javatest/TestArithmeticStack.java
 * javap -v app/src/main/java/com/example/myapplication/javatest/TestArithmeticStack
 */
public class TestArithmeticStack {


    public static void main(String args[]){
//        test();
        test4();
        tableSizeFor(65);
    }

    public static void test(){
        List<String> list = new ArrayList<>();
        list.add("a");
        int a= 100;
        int b= 200;
        int d = 800;
        int c = a+b+(a%2)+d*5;
        System.out.println(c);
    }

    public static int test1(){
        int a = 100;
        int b = 200;
        int c = 300;
        int d = 400;
        int f = a+b*c;
        int e =f = d = c = b = a = 1;
        int g = a  = 10;
        int h = b+(b=a);
        int i = c+(d=c);
        int j = a+(b+c);
        int l = b+(b+a);
        int m = a+(b+a);
        int n = a*(b+a);
        int o = (b+a)*c;
        int p = b+d+a*(c+e);
        int k = d;
        return  e;
    }


    public static int test2(){
        int a = 100;
        int b = 200;
        int d = 5;
        int c = a+b;
        return c;
    }

    public void test3(int a){
        List<String> arrayList = new ArrayList<>();
        arrayList.add("s");
    }

    public static void test4(){
        float a = 1.4f;
        float b = 1.2f;
        float c = a+b;
        System.out.println(c+"");
        System.out.println(b+"");
        System.out.println(a+"");
    }


    static  int tableSizeFor(int cap) {
        int n = cap - 1;
        n |= n >>> 1;
        System.out.println("移位1："+n);

        n |= n >>> 2;
        System.out.println("移位2："+n);

        n |= n >>> 4;
        System.out.println("移位4："+n);

        n |= n >>> 8;
        System.out.println("移位8："+n);

        n |= n >>> 16;
        System.out.println("移位16："+n);

        System.out.println(n+1);
        return  n + 1;
    }

    void testNew(){
        TestArithmeticStack stack = new TestArithmeticStack();
    }


}
