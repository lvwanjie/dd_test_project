package com.example.myapplication.fanxing;

import java.util.ArrayList;
import java.util.List;

public class FanxingTest {

    public static void main(String args[]){
        Student a = new Student();
        a.name = new Name();
    }

    public void testA(){
        Student b = new Student();
        Object s = b.getName();

    }

    // ？super 可以赋值 子类和 本身类
    public void testB(){
        Student<? super Name> student = new Student<>();
        student.name = new ChineseName();
    }


    // ? extend 可以获取
    public void testC(){
        Student<? extends Name> student = new Student<>();
        Name name = student.name;

        //例子

        Student <ChineseName> student1 = new Student<>();
        ChineseName chineseName = new ChineseName();
        student1.name = chineseName;

        Student<? extends  Name> student2 = student1;
        Name name1 = student2.name ;

    }



    //test ? extend
    public static void testD(){

        List<Name> list = new ArrayList();
        list.add(new EnglishName());
        list.add(new ChineseName());
        testE(list);   //testE 如果不适用通配符编译会报异常 List< Name> list

    }

    public static void testE(List<? extends Name> list){
    }




}
