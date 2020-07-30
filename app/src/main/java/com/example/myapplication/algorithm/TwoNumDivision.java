package com.example.myapplication.algorithm;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

public class TwoNumDivision {

    public static void main(String args[]){

        System.out.println(duvision(103,3));
    }

    public static int duvision(int dividend,int divisor){
        int i = 0;
        Queue queue ;
        HashMap hashMap;
        ArrayList list;
        while (dividend >= divisor){
            i++;
            dividend = dividend - divisor;
        }
        return i;

    }

}
