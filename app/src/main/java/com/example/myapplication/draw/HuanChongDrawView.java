package com.example.myapplication.draw;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

import java.util.Random;

import static androidx.constraintlayout.widget.Constraints.TAG;

public class HuanChongDrawView extends View {
    private int num = 1000;
    Paint mPaint;
    private Random random;
    private Bitmap bitmap;
    private Canvas canvas;
    private int f;

    public HuanChongDrawView(Context context) {
        super(context);
        init();
    }

    public HuanChongDrawView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();

    }

    public HuanChongDrawView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();

    }


    private void init(){
        mPaint = new Paint();
        mPaint.setColor(Color.parseColor("#000000"));
        mPaint.setStyle(Paint.Style.FILL);
        random = new Random();
        bitmap = Bitmap.createBitmap(1000,1000, Bitmap.Config.ARGB_8888);
        canvas = new Canvas(bitmap);


    }

    public void setNum(int num){
        this.num = num;
        invalidate();

    }

    public void setF(int f){
        this.f = f;
        invalidate();
//        if(f == 1){
//            for(int i=0;i<num;i++){
//
//                canvas.drawCircle(random.nextInt(),random.nextInt(),50,mPaint);
//            }
//        }else {
//
//        }

    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

//        for(int i=0;i<num;i++){
//
//            canvas.drawCircle(random.nextInt(),random.nextInt(),50,mPaint);
//            Log.i(TAG, "onDraw: i="+);
//        }

        if(f == 1){
            for(int i=0;i<num;i++){

                this.canvas.drawCircle(random.nextInt(),random.nextInt(),50,mPaint);

            }
            canvas.drawBitmap(bitmap,0,0,mPaint);

        }else {
            for (int i = 0; i < num; i++) {

                canvas.drawCircle(random.nextInt(), random.nextInt(), 50, mPaint);
                Log.i(TAG, "onDraw: i=" +i);
            }

        }

    }

    public  class MyThread extends Thread{
        @Override
        public void run() {
            super.run();
            invalidate();
        }
    }
}
