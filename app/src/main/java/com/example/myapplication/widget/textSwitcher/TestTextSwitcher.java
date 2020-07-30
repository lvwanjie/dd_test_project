package com.example.myapplication.widget.textSwitcher;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.NestedScrollingParent3;

import android.os.Build;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroupOverlay;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.TextSwitcher;
import android.widget.TextView;
import android.widget.ViewSwitcher;

import com.example.myapplication.R;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

public class TestTextSwitcher extends AppCompatActivity {

    private TextSwitcher textSwitcher;
    private Button button;
    private int i = 0;
    private int j = 0;
    private AdTipCarousel adTipCarousel;
    private Button btAd;
    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN_MR2)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_text_switcher);
        textSwitcher = findViewById(R.id.text_switcher);
        adTipCarousel = findViewById(R.id.ad_tip_carousel);
        ViewGroupOverlay viewGroupOverlay = adTipCarousel.getOverlay();
        button = findViewById(R.id.button);
        btAd = findViewById(R.id.bt_ad);
        textSwitcher.setFactory(new ViewSwitcher.ViewFactory() {
            @Override
            public View makeView() {
                TextView textView = new TextView(TestTextSwitcher.this);
                textView.setGravity(Gravity.CENTER);
                FrameLayout.LayoutParams params = new FrameLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,ViewGroup.LayoutParams.MATCH_PARENT);
                textView.setLayoutParams(params);
                return textView;
            }
        });

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String str ="cur="+(i++);
                if(i%3==0 || i%3==1){
                    str = "这是两行这是两行这是两这是两行这是两行这是两";
                }
                textSwitcher.setText(str);
            }
        });


        new Timer().schedule(new TimerTask() {
            @Override
            public void run() {
                j++;
                final int k = j%2;
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        textSwitcher.setText(list.get(0));

                    }
                });

            }
        },1000,1000);
        list = getFakeData();

        btAd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                adTipCarousel.setData(list);
            }
        });
    }

    private List<String> list;


    public List getFakeData(){
        HashMap hashMap;
        List list = new ArrayList();

        for(int i=0;i<1;i++){
            String s = "这是数据是数据"+i;
            list.add(s);
        }
        return list;
    }
}
