package com.example.myapplication.javatest;

import android.text.TextUtils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class pattern {


    public static void main(String args[]) {
//        test1();
        String s = resetNickName("1234567890abcdefg");
        System.out.println(s);
    }


    public static void test1() {
        String part = "[A-Z]|[a-z]";
        Pattern pattern2 = Pattern.compile(part);
        Matcher matcher2 = pattern2.matcher("SAa");
        System.out.println(matcher2.find());
    }

    private static String resetNickName(String str){
        if(str.length() <= 16) {
            return str;

        }
            str = str.substring(0,16) +"..." ;

        return str;
    }
}
