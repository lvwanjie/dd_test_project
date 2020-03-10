package com.example.myapplication.anim;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

import androidx.annotation.Nullable;

import static androidx.constraintlayout.widget.Constraints.TAG;

public class WaveAnimView extends View {
    private Path path;
    private Path path1;
    private Paint paint;
    private Paint paint1;
    private float offsetX;

    public WaveAnimView(Context context) {
        super(context);
        init();
    }

    public WaveAnimView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public WaveAnimView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init(){
        paint = new Paint();
        paint1 = new Paint();
        paint.setStyle(Paint.Style.FILL);
        paint1.setStyle(Paint.Style.FILL);
        paint.setColor(Color.parseColor("#9978c5f3"));
        paint1.setColor(Color.parseColor("#7f78c5f2"));
//        path = new Path();
//        path.moveTo(100,100);
//        path.lineTo(200,200);
//        path.moveTo(300,300);
//        path.lineTo(400,400);
        path = getSinPath(0);
        path1 = getSinPath(400);
//        path1 = getQPath();
        setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                startAnim();
            }
        });
    }

    private void startAnim(){
        ObjectAnimator objectAnimator = ObjectAnimator.ofFloat(this,"offsetX",0,100);
        objectAnimator.setDuration(1000);
        objectAnimator.start();
    }

    public void setOffsetX(float offsetX){
        Log.i(TAG, "setOffsetX: "+offsetX);
        this.offsetX = offsetX;
        setTranslationX(-offsetX);
//        path1.offset(-15,0);
        invalidate();
    }

    private Path getSinPath(int u){
        Path path = new Path();
        path.moveTo(0,300);
        path.lineTo(0,0);
        for(int i=0;i<2080;i++){
            path.lineTo(i, (float)(50* Math.sin(0.01*i +u))+50);
        }

        path.lineTo(2080,300);


        return path;
    }




    private Path getQPath(){
        Path path = new Path();
        path.moveTo(100,100);
        path.quadTo(200,200,300,100);
        path.quadTo(400,0,500,100);
        return  path;
    }


    @Override
    protected void onDraw(Canvas canvas) {
        canvas.drawPath(path,paint);
//        path.quadTo(offsetX,0,offsetX+100,0);
//        canvas.drawPath(path1,paint);
//        canvas.drawPath(path1,paint1);
    }
}
