package com.example.myapplication.draw;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Shader;
import android.util.AttributeSet;
import android.view.View;

import androidx.annotation.Nullable;

public class FadeView extends View {
    private Paint p;
    private Paint p1;

    public FadeView(Context context) {
        super(context);
        p = new Paint();
        p1 = new Paint();
    }

    public FadeView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        p = new Paint();
        p1 = new Paint();

    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        Matrix matrix = new Matrix();
        Shader fade = new LinearGradient(0, 0, 0, 1, 0xFF78c5f2, 0, Shader.TileMode.CLAMP);

        matrix.setScale(1, 40);
        matrix.postRotate(180);
        matrix.postTranslate(10, 30);
        fade.setLocalMatrix(matrix);
        p.setShader(fade);
        p1.setColor(Color.BLACK);
        canvas.drawRect(10, 10, 100, 100, p1);
        canvas.drawRect(10, 10, 100, 100, p);


    }
}
