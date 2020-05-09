package com.example.myapplication.javatest;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class pattern {


    public static void main(String args[]) {
        test1();
    }


    public static void test1() {
        String part = "[A-Z]|[a-z]";
        Pattern pattern2 = Pattern.compile(part);
        Matcher matcher2 = pattern2.matcher("SAa");
        System.out.println(matcher2.find());
    }
}
