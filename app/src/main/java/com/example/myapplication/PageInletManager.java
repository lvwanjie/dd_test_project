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
            "com.example.myapplication.draw.ShadowDrawActivity",
            "com.example.myapplication.windows.TestPupWindowActivity",
            "com.example.myapplication.bujuTest.BUJU2Activity",
            "com.example.myapplication.zhedielayout.ScrollingActivity2",
            "com.example.myapplication.anim.HpAnimActivity",
            "com.example.myapplication.widget.editText.EditInputFilterActivity",
            "com.example.myapplication.anim.HPTestAnimActivity",
            "com.example.myapplication.testFragment.TestFragmentActivity",
            "com.example.myapplication.widget.timePicker.TimePickerActivity",
            "com.example.myapplication.zhedielayout.NestScrollActivity",
            "com.example.myapplication.testClassLoader.CLActivity",
            "com.example.myapplication.widget.nestScroll.NestScrollTestActivity",
            "com.example.myapplication.ANRTest.ANRTestActivity",
            "com.example.myapplication.draw.MeasureTestActivity",
            "com.example.myapplication.launchMode.TestLaunchModeActivity"
    };



    public static List<String> getPageInfoList(){
        return Arrays.asList(pageInfos);
    }

}
