package com.example.myapplication.designpattern.proxy;

public class Singler implements ISing {
    @Override
    public void sing() {
        System.out.println("开始唱歌");
    }

    @Override
    public void dance() {
        System.out.println("开始跳舞");
        System.out.println("ssssss");
    }
}
