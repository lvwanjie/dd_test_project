package com.example.myapplication.algorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 括号的组合种类
 * 题：给出一个数字，列出括号的组合种类
 * 例：n = 3
 *     组合 （（（））），（（）（）），（（））（），（）（（）），（）（）（），
 */

public class BracketCompose {


    public static void main(String args[]){
        List list = new ArrayList();
        compose(list,"",3,3);
        System.out.println(Arrays.toString(list.toArray()));
    }

    public static void compose(List list,String bracket,int left,int right){

        if(left>0){
            compose(list,bracket+"(",left-1,right);
        }
        if(right>left){
            compose(list,bracket+")",left,right-1);
        }

        if(right == 0){
            list.add(bracket);
        }

    }
}
