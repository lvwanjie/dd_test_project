package com.example.myapplication.surfaceview;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;

public class DrawView extends View {

    private Paint paint = new Paint();
    private int index = 0;

    public DrawView(Context context) {
        super(context);
    }

    public DrawView(Context context, AttributeSet attrs) {
        super(context, attrs);
        paint.setColor(Color.BLACK);
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(2);
    }


    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int canvasHeight = canvas.getHeight();
        int canvasWidth = canvas.getWidth();
        Rect rect = canvas.getClipBounds();
        drawPath(canvas);
        int saveCount = canvas.getSaveCount();
        int count = canvas.save();

    }


    private void drawPath(Canvas canvas){
        index ++;
        Path path = new Path();
        path.moveTo(0 +index*10,0);
        path.lineTo(100 +(index*10),100);
        path.close();
        canvas.drawPath(path,paint);
    }
}
