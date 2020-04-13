package com.example.myapplication.algorithm;


import java.util.Arrays;

/**
 * 移除数组中重复数据
 * 例子 【1，1，2】to 【1，2】
 */
public class RemoveRepeat {

    public static int num[] ={1,2,2,3,3,5,6,3};
    public static void main(String args[]){
        remove(num);
        System.out.println(Arrays.toString(num));
    }


    public static void remove(int num[]){

        int i = 0;
        for(int j=1;j<num.length;j++){
            if(num[i]!=num[j]){
                i++;
            }
            num[i] = num[j];
        }

    }
}
