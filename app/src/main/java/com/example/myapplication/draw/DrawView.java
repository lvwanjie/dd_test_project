package com.example.myapplication.draw;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

public class DrawView extends View {

    private String TAG ="DrawView";
    private String TAGTT ="DrawViewTT";
    private int i;

    public DrawView(Context context) {
        super(context);
    }

    public DrawView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        Log.i(TAG, "onDraw: "+i++);
//        Paint paint = new Paint();
//        paint.setColor(Color.BLUE);
//        RectF rectF = new RectF(0,0,getWidth(),getHeight());
//        canvas.drawRoundRect(rectF, 100, 100,paint);
        super.onDraw(canvas);
    }

    @Override
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        super.onLayout(changed, left, top, right, bottom);
        Log.i(TAG, "onLayout: ");
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        Log.i(TAG, "onMeasure: ");
    }

    @Override
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        Log.i(TAGTT, "onAttachedToWindow: ");
    }

    @Override
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        Log.i(TAGTT, "onDetachedFromWindow: ");
    }

    @Override
    public void onWindowSystemUiVisibilityChanged(int visible) {
        super.onWindowSystemUiVisibilityChanged(visible);
        Log.i(TAGTT, "onWindowSystemUiVisibilityChanged: "+visible);
    }

    @Override
    protected void onWindowVisibilityChanged(int visibility) {
        super.onWindowVisibilityChanged(visibility);
        Log.i(TAGTT, "onWindowVisibilityChanged: "+visibility);
    }

}
