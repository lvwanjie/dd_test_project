package com.example.myapplication;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapRegionDecoder;
import android.os.Bundle;
import android.os.Handler;
import android.os.SystemClock;
import android.util.Log;
import android.view.Surface;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.asynclayoutinflater.view.AsyncLayoutInflater;
import androidx.coordinatorlayout.widget.CoordinatorLayout;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

import static androidx.constraintlayout.widget.Constraints.TAG;

public class MainActivity1 extends Activity {

    BitmapRegionDecoder bitmapRegionDecoder;
    AtomicInteger atomicInteger = new AtomicInteger();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(com.example.testmoudel.R.layout.test_module_activity_main);
        String s = getResources().getString(com.example.testmoudel.R.string.text_sd);
        TextView textView = findViewById(R.id.text);
        textView.setText(s);
        PopupWindow popupWindow;
//        popupWindow.showAsDropDown();

        TextView t = findViewById1(0);
        atomicInteger.addAndGet(1);
        View view;
//        view.setAlpha();
        ArrayList list;
        SurfaceView surfaceView = new SurfaceView(this);
        SurfaceHolder holder = surfaceView.getHolder();
//        holder.lockCanvas()
        Handler handler = new Handler();
        long l = SystemClock.uptimeMillis();
        Log.i(TAG, "onCreate: l="+l);

    }


    public <T extends View> T findViewById1( int id) {
        return getWindow().findViewById(id);
    }


    private View view;
    @Override
    protected void onResume() {
        super.onResume();


        Handler handler = new Handler();
        if(view != null){
            view.post(new Runnable() {
                @Override
                public void run() {

                }
            });
        }

    }
}
