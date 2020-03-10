package com.example.myapplication.surfaceview;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PixelFormat;
import android.graphics.PorterDuff;
import android.util.AttributeSet;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

import com.example.myapplication.R;

public class MySurfaceView extends SurfaceView {

    private Bitmap bitmap1;
    private Bitmap bitmap2;
    private MyThread myThread;

    public MySurfaceView(Context context) {
        super(context);
        init();
    }

    public MySurfaceView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public MySurfaceView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public void init(){
        bitmap1 = BitmapFactory.decodeResource(getResources(),R.mipmap.ic_live_shop_cart);
        bitmap2 = BitmapFactory.decodeResource(getResources(),R.mipmap.icon_dangdu_card_spread_out);
        myThread = new MyThread();
        SurfaceHolder holder = getHolder();
        setZOrderOnTop(true);
        getHolder().setFormat(PixelFormat.TRANSLUCENT);
        holder.addCallback(new SurfaceHolder.Callback() {
            @Override
            public void surfaceCreated(SurfaceHolder holder) {
                myThread.start();
            }

            @Override
            public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {

            }

            @Override
            public void surfaceDestroyed(SurfaceHolder holder) {

            }
        });

    }



    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        canvas.drawBitmap(bitmap1,new Matrix(),new Paint());

    }

    class MyThread extends  Thread{

        @Override
        public void run() {
            Canvas canvas = null;
            try {
                canvas = getHolder().lockCanvas();
                Matrix matrix = new Matrix();
//                matrix.postTranslate(100,100);
//                matrix.preTranslate(100,100);
                matrix.setTranslate(100,100);
                canvas.drawColor(Color.TRANSPARENT, PorterDuff.Mode.CLEAR);
                canvas.drawBitmap(bitmap2,matrix,new Paint());
            }finally {
                getHolder().unlockCanvasAndPost(canvas);
            }


        }
    }

}
