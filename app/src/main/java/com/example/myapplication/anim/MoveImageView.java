package com.example.myapplication.anim;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.os.Handler;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;

import androidx.annotation.Nullable;


import java.util.Timer;
import java.util.TimerTask;

import static androidx.constraintlayout.widget.Constraints.TAG;

public class MoveImageView extends ImageView {

    private float currentX;
    private float currentY;

    public MoveImageView(Context context) {
        super(context);
    }

    public MoveImageView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                i = 0;
                new Timer().scheduleAtFixedRate(new TimerTask() {
                    @Override
                    public void run() {
                        invalidate();
                    }
                },100,100);
            }
        });
    }

    public MoveImageView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    private void startAnim(){
        ObjectAnimator objectAnimator = ObjectAnimator.ofFloat(this,"translationX",0,300);
        objectAnimator.setDuration(10000);
        objectAnimator.start();
        invalidate();
    }



//    @Override
//    public boolean onTouchEvent(MotionEvent event) {
//        switch (event.getAction()){
//            case MotionEvent.ACTION_DOWN:
//                this.currentX = event.getRawX();
//                this.currentY = event.getRawY();
//                Log.i(TAG, "onTouchEvent: DOWN_moveX =" +currentX);
//                startAnim();
//                break;
//            case MotionEvent.ACTION_MOVE:
//                float moveX = event.getRawX() - this.currentX;
//                float moveY = event.getRawY() - this.currentY;
//                this.currentX = event.getRawX();
//                this.currentY = event.getRawY();
//                Log.i(TAG, "onTouchEvent: getX =" +getX()+"getLeft="+getLeft());
////                Log.i(TAG, "onTouchEvent: moveY =" +getY());
//                setX(getX()+moveX);
//                setY(getY()+moveY);
//                break;
//        }
//
//        return true;
//
//    }

    private int i = 0;
    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        Log.i(TAG, "onDraw: i="+i++);
    }
}
