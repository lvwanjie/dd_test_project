package com.example.myapplication.widget.textSwitcher;

import android.content.Context;
import android.graphics.Color;
import android.util.AttributeSet;
import android.util.Log;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextSwitcher;
import android.widget.TextView;
import android.widget.ViewSwitcher;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.myapplication.R;

import java.util.List;

public class AdTipCarousel extends FrameLayout {

    private static final int EACH_TIME = 1000;
    private View mContent;
    private TextSwitcher textSwitcher;
    private TextView etvClose;
    private List<String> list;
    private int i;
    private boolean isRunning;
    private String TAG = "AdTipCarousel.java";

    public AdTipCarousel(@NonNull Context context) {
        super(context);
        init();
    }

    public AdTipCarousel(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    private void init(){
        mContent = LayoutInflater.from(getContext()).inflate(R.layout.carousel_ad_tip,this);
        textSwitcher = mContent.findViewById(R.id.tv_switcher);
        etvClose = mContent.findViewById(R.id.etv_close);
        textSwitcher.setFactory(new ViewSwitcher.ViewFactory() {
            @Override
            public View makeView() {
                TextView textView = new TextView(getContext());
                FrameLayout.LayoutParams params = new FrameLayout.LayoutParams(
                        ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
                textView.setLayoutParams(params);
                textView.setTextColor(Color.parseColor("#DE7600"));
                textView.setTextSize(TypedValue.COMPLEX_UNIT_PX,12);
                return textView;
            }
        });
    }


    public void setData(List<String> list){
        this.list = list;
        start();
        showText();
    }

    public void start(){
        isRunning = true;
        postDelayed(mRunnable,EACH_TIME);
    }

    public void stop(){
        isRunning = false;
        removeCallbacks(mRunnable);
    }

    private void showText(){
        Log.i(TAG, "showText: ");
        if(list == null || list.size() ==0){
            stop();
            return;
        }
        if(i >=list.size()){
            i = 0;
        }
        textSwitcher.setText(list.get(i));
        i++;
    }


    private Runnable mRunnable = new Runnable()  {

        @Override
        public void run() {
            if (isRunning) {
                showText();
                postDelayed(mRunnable,EACH_TIME);
            }
        }
    };






}
