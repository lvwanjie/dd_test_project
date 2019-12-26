package com.example.myapplication;

import com.example.myapplication.pubulayout.PubuActivity;

import java.util.Arrays;
import java.util.List;

public class PageInletManager {

    public static String pageInfos[] = {
         "com.example.myapplication.windows.TestWindowActivity",
            "com.example.myapplication.surfaceview.DrawTestActivity",
            "com.example.myapplication.pubulayout.PubuActivity",
            "com.example.myapplication.draw.DrawActivity",
            "com.example.myapplication.bujuTest.BuJuActivity"
    };



    public static List<String> getPageInfoList(){
        return Arrays.asList(pageInfos);
    }

}
