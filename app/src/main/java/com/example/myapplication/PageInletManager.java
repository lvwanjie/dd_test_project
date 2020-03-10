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
            "com.example.myapplication.bujuTest.BuJuActivity",
            "com.example.myapplication.bujuTest.BuJu1Activity",
            "com.example.myapplication.anim.ProductCardAnimActivity",
            "com.example.myapplication.anim.ProductCardAnimActivity",
            "com.example.myapplication.bujuTest.MergeTestActivity",
            "com.example.myapplication.anim.MoveActivity",
            "com.example.myapplication.anim.WaveAnimActivity",
            "com.example.myapplication.livemessage.LiveRecyclerActivity",
            "com.example.myapplication.draw.FadeTestActivity",
            "com.example.myapplication.surfaceview.SurfaceActivity",
            "com.example.myapplication.bujuTest.MergeTestActivity",
            "com.example.myapplication.zhedielayout.MountingActivity",
            "com.example.myapplication.zhedielayout.ScrollingActivity",
            "com.example.myapplication.zhedielayout.CoordinatorTestActivity"
    };



    public static List<String> getPageInfoList(){
        return Arrays.asList(pageInfos);
    }

}
