package com.example.myapplication.WebView;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.webkit.WebView;


public class MyWebView extends WebView {

    public static String TAG = "MyWebView";

    public MyWebView(Context context) {
        super(context);
    }

    public MyWebView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }


    @Override
    public void onStopNestedScroll(View child) {
        super.onStopNestedScroll(child);
        Log.i(TAG, "onStopNestedScroll: ");
    }

    @Override
    public boolean onNestedFling(View target, float velocityX, float velocityY, boolean consumed) {
        Log.i(TAG, "onNestedFling: ");

        return super.onNestedFling(target, velocityX, velocityY, consumed);
    }

    @Override
    public boolean dispatchNestedFling(float velocityX, float velocityY, boolean consumed) {
        Log.i(TAG, "dispatchNestedFling: ");
        return super.dispatchNestedFling(velocityX, velocityY, consumed);
        
    }

    @Override
    public boolean onNestedPreFling(View target, float velocityX, float velocityY) {
        Log.i(TAG, "onNestedPreFling: ");
        return super.onNestedPreFling(target, velocityX, velocityY);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        switch (event.getAction()){
            case  MotionEvent.ACTION_UP:
                break;
        }
        return super.onTouchEvent(event);
        

    }
}
