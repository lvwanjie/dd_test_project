package com.example.myapplication.waveanim;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.graphics.BitmapRegionDecoder;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

public class WaveAnimView extends View {

    private String TAG = "WaveAnimView";

    public WaveAnimView(Context context) {
        super(context);
    }

    public WaveAnimView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public WaveAnimView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }


    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
//        canvas.drawPath();
        canvas.drawColor(Color.BLUE);
//        Path path = new Path();
//        path.moveTo(50,50);
//        path.lineTo(300,100);
//        path.lineTo(600,100);
//        path.lineTo(500,600);
//        path.quadTo(0,0,100,100);
//        Matrix matrix = new Matrix();
//        matrix.setRotate(30);

        Path path = getPath();

        Paint paint =new Paint();
        paint.setColor(Color.BLACK);
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(3);


        canvas.drawPath(path,paint);
//        canvas.drawRect(new RectF(0,0,100,100),new Paint());
    }

    public void startAnim(){
//        ObjectAnimator objectAnimator = ObjectAnimator.ofFloat(this,"pointX",0,1);
    }

    public void setPointX1(float startX,float endX){

    }

    public Path getPath(){
        float startX = 0;
        float endX = 1000;
        Path path = new Path();
        path.moveTo(startX,200);
        float y = 0;
        float d = 0;
        while (startX<endX){
            y = (float) (100*Math.sin(d/180*Math.PI))+200;
            d+=10;
            Log.i(TAG, "getPath:startX= "+startX+";y="+y);
            path.lineTo(startX,y);
            startX += 10;
        }

        return path;
    }




}
