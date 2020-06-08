package com.example.myapplication.widget.nestScroll;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.core.view.NestedScrollingParent;
import androidx.core.view.NestedScrollingParent2;

public class ScrollParent extends LinearLayout implements NestedScrollingParent , NestedScrollingParent2 {

    private static String TAG = "ScrollParent.java";
    public ScrollParent(Context context) {
        super(context);
    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    public ScrollParent(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        setNestedScrollingEnabled(true);

    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public ScrollParent(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        setNestedScrollingEnabled(true);
    }


    @Override
    public void onNestedPreScroll(View target, int dx, int dy, int[] consumed) {
        super.onNestedPreScroll(target, dx, dy, consumed);
        Log.i(TAG, "onNestedPreScroll: dx="+dx+"    dy="+dy+"    consumed="+consumed);
    }

    @Override
    public void onNestedScroll(View target, int dxConsumed, int dyConsumed, int dxUnconsumed, int dyUnconsumed) {
        super.onNestedScroll(target, dxConsumed, dyConsumed, dxUnconsumed, dyUnconsumed);
        Log.i(TAG, "onNestedScroll: dxConsumed="+
                dxConsumed+"    dyConsumed="+dyConsumed+"    dxUnconsumed="+dxUnconsumed+"    dyUnconsumed="+dyUnconsumed);
    }

    @Override
    public boolean onStartNestedScroll(View child, View target, int nestedScrollAxes) {
        Log.i(TAG, "onStartNestedScroll: nestedScrollAxes"+nestedScrollAxes);
        return true;
    }

    @Override
    public boolean onNestedFling(View target, float velocityX, float velocityY, boolean consumed) {
        Log.i(TAG, "onNestedFling: velocityX="+velocityX+"    velocityY="+velocityY+"    consumed="+consumed);
        return super.onNestedFling(target, velocityX, velocityY, consumed);
    }

    @Override
    public boolean onNestedPreFling(View target, float velocityX, float velocityY) {
        Log.i(TAG, "onNestedPreFling: velocityX="+velocityX+"    velocityY="+velocityY);
        return super.onNestedPreFling(target, velocityX, velocityY);
    }

    @Override
    public void onStopNestedScroll(View child) {
        Log.i(TAG, "onStopNestedScroll: ");
        super.onStopNestedScroll(child);
    }

    @Override
    public boolean onStartNestedScroll(@NonNull View child, @NonNull View target, int axes, int type) {

        return true;
    }

    @Override
    public void onNestedScrollAccepted(@NonNull View child, @NonNull View target, int axes, int type) {

    }

    @Override
    public void onStopNestedScroll(@NonNull View target, int type) {

    }

    @Override
    public void onNestedScroll(@NonNull View target, int dxConsumed, int dyConsumed, int dxUnconsumed, int dyUnconsumed, int type) {
        Log.i(TAG, "onNestedScroll: dxConsumed="+
                dxConsumed+"    dyConsumed="+dyConsumed+"    dxUnconsumed="+dxUnconsumed+"    dyUnconsumed="+dyUnconsumed +"  type = "+type);
    }

    @Override
    public void onNestedPreScroll(@NonNull View target, int dx, int dy, @NonNull int[] consumed, int type) {
        Log.i(TAG, "onNestedPreScroll: dx="+dx+"    dy="+dy+"    consumed="+consumed.toString() +"    type="+type);

    }
}
