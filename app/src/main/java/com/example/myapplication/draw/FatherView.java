package com.example.myapplication.draw;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.util.Log;
import android.widget.LinearLayout;

import androidx.annotation.Nullable;

public class FatherView extends LinearLayout {


    private String TAG = "FatherView";
    private int i;

    public FatherView(Context context) {
        super(context);
    }

    public FatherView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public FatherView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        Log.i(TAG, "onDraw: i="+i++);
        super.onDraw(canvas);
    }
}
