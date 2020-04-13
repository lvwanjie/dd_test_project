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
            "com.example.myapplication.zhedielayout.CoordinatorTestActivity",
            "com.example.myapplication.tupian.ImageActivity",
            "com.example.myapplication.draw.InvalidateTestActivity",
            "com.example.myapplication.draw.TranslateTestActivity",
            "com.example.myapplication.WebView.WebActivity",
            "com.example.myapplication.pubulayout.TestRecyclerViewActivity",
            "com.example.myapplication.widget.progressBar.ProgressBarActivity",
            "com.example.myapplication.draw.HuanChongActivity",
            "com.example.myapplication.parcelable.ParcelableActivity",
            "com.example.myapplication.draw.ShadowDrawActivity"
    };



    public static List<String> getPageInfoList(){
        return Arrays.asList(pageInfos);
    }

}
