package com.example.myapplication.livemessage;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.util.AttributeSet;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;

public class RoundRecyclerview extends RecyclerView {
    public RoundRecyclerview(@NonNull Context context) {
        super(context);
    }

    public RoundRecyclerview(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public RoundRecyclerview(@NonNull Context context, @Nullable AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }

    @Override
    public void onDraw(Canvas c) {


        RectF rectF = new RectF(0,0,getWidth(),getHeight());
        Path path = new Path();
        float f[]={100,100,100,100,0,0,0,0};
        path.addRoundRect(rectF,f,Path.Direction.CCW);
        c.clipPath(path);
                super.onDraw(c);

    }

    @Override
    protected float getBottomFadingEdgeStrength() {
        return 0;
    }
}
