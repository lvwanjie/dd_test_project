package com.example.myapplication.draw;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RadialGradient;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.drawable.ColorDrawable;
import android.util.AttributeSet;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;

import com.example.myapplication.MyUtils;
import com.example.myapplication.R;

public class ShadowDrawView extends View {

    private Rect rect;
    private Paint mPain;
    private Path cornerShadowPath;
    private int shadowStartColor;
    private int shadowMiddleColor;
    private int shadowEndColor;


    public ShadowDrawView(Context context) {
        super(context);
        init();
    }

    public ShadowDrawView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    private void init(){
        rect = new Rect(0,0,200,200);
        mPain = new Paint();
        mPain.setStyle(Paint.Style.FILL);
        mPain.setColor(Color.parseColor("#f00000"));
        getPath();
        this.shadowStartColor = ContextCompat.getColor(getContext(), com.google.android.material.R.color.design_fab_shadow_start_color);
        this.shadowMiddleColor = ContextCompat.getColor(getContext(), com.google.android.material.R.color.design_fab_shadow_mid_color);
        this.shadowEndColor = ContextCompat.getColor(getContext(), com.google.android.material.R.color.design_fab_shadow_end_color);
//        this.shadowStartColor = Color.parseColor("#f00000");
//        this.shadowMiddleColor = Color.parseColor("#000000");
//        this.shadowEndColor = Color.parseColor("#78c5f2");
    }


    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
//        canvas.drawCircle(30,30,20,mPain);
//        int saved = canvas.save();
//        canvas.translate(MyUtils.dp2Px(getContext(),30),MyUtils.dp2Px(getContext(),30));
//        canvas.drawRect(rect,mPain);
////        canvas.restore();
////        canvas.save();
        canvas.translate(MyUtils.dp2Px(getContext(),30),MyUtils.dp2Px(getContext(),30));
        mPain.setShader(new RadialGradient(0.0F, 0.0F, 100, new int[]{0, this.shadowStartColor, this.shadowMiddleColor, this.shadowEndColor}, new float[]{0.0F, 0.8f, 0.9f, 1.0F}, Shader.TileMode.CLAMP));
        canvas.drawRect(rect,mPain);

        canvas.translate(MyUtils.dp2Px(getContext(),100),MyUtils.dp2Px(getContext(),100));
        mPain.setShader(new RadialGradient(0.0F, 0.0F, 100, new int[]{0, this.shadowStartColor, this.shadowMiddleColor, this.shadowEndColor}, new float[]{0.0F, 0.8f, 0.9f, 1.0F}, Shader.TileMode.CLAMP));
        canvas.drawPath(cornerShadowPath,mPain);
//        canvas.restore();




//        int saved = canvas.save();

//        canvas.translate();
    }


    private void getPath(){
        RectF innerBounds = new RectF(-100, -100, 100, 100);
        RectF outerBounds = new RectF(innerBounds);
        outerBounds.inset(-15, -15);
        if (this.cornerShadowPath == null) {
            this.cornerShadowPath = new Path();
        } else {
            this.cornerShadowPath.reset();
        }

        this.cornerShadowPath.setFillType(Path.FillType.EVEN_ODD);
        this.cornerShadowPath.moveTo(-100, 0.0F);
        this.cornerShadowPath.rLineTo(-15, 0.0F);
        this.cornerShadowPath.arcTo(outerBounds, 180.0F, 90.0F, false);
        this.cornerShadowPath.arcTo(innerBounds, 270.0F, -90.0F, false);
        this.cornerShadowPath.close();
    }
}
