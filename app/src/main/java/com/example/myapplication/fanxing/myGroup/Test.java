package com.example.myapplication.fanxing.myGroup;

import android.view.View;

import com.example.myapplication.fanxing.myGroup.group.Group;
import com.example.myapplication.fanxing.myGroup.group.Group1;
import com.example.myapplication.fanxing.myGroup.people.BaseBasePeople;
import com.example.myapplication.fanxing.myGroup.people.BasePeople;
import com.example.myapplication.fanxing.myGroup.people.Man;
import com.example.myapplication.fanxing.myGroup.people.Student;
import com.example.myapplication.fanxing.myGroup.people.Woman;

import java.util.ArrayList;
import java.util.List;

public class Test {


//    public void testExtend(){
//        Group<? extends BasePeople> group = new Group();
//        group.add(new BasePeople());
//        group.add(new Man());
//        group.add(new Student());
//        List<? extends Man> list = new ArrayList<>();
//        list.add(new BasePeople());
//    }
//
//    public void testExtend1(){
//        Group1<? extends BasePeople> group1 = new Group1();
//        group1.add(new BasePeople());
//        group1.add(new Man());
//        group1.add(new Student());
//    }
//
//
//
//    public void testSuper(){
//        Group<? super Man> group = new Group<>();
//        group.add(new Man());
//        group.add(new BasePeople());
//        group.add(new Student());
//
//        Group<Man> group1 = new Group();
//        group1.add(new Student());
//    }

    public void testSuper1(){
        Group1<? super BasePeople> group = new Group1<>();
        group.add(new Man());
        group.add(new BasePeople());
        group.add(new Student());

        Group1<Man> group1 = new Group1();
        group1.add(new Student());

        List<? super BasePeople> list = new ArrayList<>();
        list.add(new BasePeople());
//        BasePeople basePeople =  list.get(0);
        View view;

    }


    public void testMethodExentd(){
        com.example.myapplication.fanxing.myGroup.people.List list = new com.example.myapplication.fanxing.myGroup.people.List();
        BaseBasePeople student = list.get(0);
    }

}
