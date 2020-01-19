package com.example.myapplication.anim;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.graphics.BitmapFactory;
import android.graphics.Camera;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

import androidx.annotation.DrawableRes;
import androidx.annotation.Nullable;

import com.example.myapplication.R;

public class CardRotateView extends View {


    private Drawable defaultFrontDrawable;
    private Drawable defaultBackDrawable;
    private Drawable currentFrontDrawable;
    private Drawable currentBackDrawable;
    private boolean isRotateToBack;
    private AnimatorSet animatorSet;
    private float degree;
    private Camera camera;
    private Matrix matrix;

    public CardRotateView(Context context) {
        super(context);
        init();
    }

    public CardRotateView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        Rect rect = new Rect(0,0,getMeasuredWidth(),getMeasuredHeight());
        if(defaultBackDrawable != null){
            defaultBackDrawable.setBounds(rect);
        }
        if(defaultFrontDrawable != null){
            defaultFrontDrawable.setBounds(rect);
        }
    }

    public boolean isRotateBack(){
        return this.isRotateToBack;
    }

    private void setCurrentDrawable(){
        if(isRotateToBack){
            currentFrontDrawable = defaultBackDrawable;
            currentBackDrawable = defaultFrontDrawable;
        }else {
            currentFrontDrawable = defaultFrontDrawable;
            currentBackDrawable = defaultBackDrawable;
        }
    }

    private void init(){
        camera = new Camera();
        matrix = new Matrix();
        animatorSet = new AnimatorSet();
        ObjectAnimator scaleObject = ObjectAnimator.
                ofFloat(this,"scaleX",1f,1.1f,1f);
        scaleObject.setDuration(200);
        ObjectAnimator objectAnimator = ObjectAnimator.
                ofFloat(this,"degree",0,180);
        objectAnimator.setDuration(500);
        objectAnimator.setStartDelay(100);
        animatorSet.play(scaleObject).before(objectAnimator);
        animatorSet.addListener(new AnimatorListenerAdapter() {
            @Override
            public void onAnimationEnd(Animator animation) {
                isRotateToBack = !isRotateToBack;
            }
        });
        defaultFrontDrawable = new BitmapDrawable(BitmapFactory.decodeResource(getResources(),R.mipmap.icon_dangdu_card_pack_up));
        defaultBackDrawable = new BitmapDrawable(BitmapFactory.decodeResource(getResources(),R.mipmap.icon_dangdu_card_spread_out));
        setCurrentDrawable();
    }

    public void setDegree(float degree){
        this.degree = degree;
        invalidate();
    }

    public void startAnim(){
        animatorSet.start();
        setCurrentDrawable();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        camera.save();
        float degree = this.degree;
        if(degree>90){
            degree +=180;
        }
        camera.rotateY(degree);
        camera.getMatrix(matrix);
        camera.restore();
        matrix.preTranslate(-getWidth()/2,0);
        matrix.postTranslate(getWidth()/2,0);
        canvas.concat(matrix);
        if(degree<90){
            currentFrontDrawable.draw(canvas);
        }else {
            currentBackDrawable.draw(canvas);
        }
    }

}
