package com.example.myapplication.anim;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Camera;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;

import androidx.annotation.Nullable;
import com.example.myapplication.R;

public class Card3dView extends View {

    private float degree;
    private ObjectAnimator objectAnimator;
    private Camera camera;
    private Matrix matrix;
    private Bitmap bitmap1;
    private Bitmap bitmap2;
    private Paint paint;
    private AnimatorSet animatorSet;
    private ObjectAnimator scaleObject;
    // 是否旋转到了背面，奇数次旋转为true，0 和偶数次旋转为
    private boolean isRotateToBack;
    private Bitmap frontBitmap;
    private Bitmap backBitmap;
    BitmapDrawable bitmapDrawable1;
    BitmapDrawable bitmapDrawable2;
    BitmapDrawable frontDrawable;
    BitmapDrawable backDrawable;


    public Card3dView(Context context) {
        super(context);
        init();

    }

    public Card3dView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }


    public boolean isRoateBack(){
        return isRotateToBack;
    }

    private void init(){
        camera = new Camera();
        matrix = new Matrix();
        paint = new Paint();
        bitmap1 = BitmapFactory.decodeResource(getResources(),
                R.mipmap.icon_dangdu_card_pack_up);
        bitmap2 = BitmapFactory.decodeResource(getResources(),
                R.mipmap.icon_dangdu_card_spread_out);
         bitmapDrawable1 = new BitmapDrawable(bitmap1);
         bitmapDrawable2 = new BitmapDrawable(bitmap2);
        setFrontAndBackBitmap();
        initAnim();
    }

    private void setFrontAndBackBitmap(){
        if(isRotateToBack){
            frontBitmap = bitmap2;
            backBitmap = bitmap1;
            frontDrawable = bitmapDrawable2;
            backDrawable = bitmapDrawable1;
        }else {
            frontBitmap = bitmap1;
            backBitmap = bitmap2;
            frontDrawable = bitmapDrawable1;
            backDrawable = bitmapDrawable2;
        }
    }

    private void initAnim(){
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
    }



    public void startAnim(){
        animatorSet.start();
        setFrontAndBackBitmap();
    }

    public void setDegree(float degree){
        this.degree = degree;
        invalidate();
    }


    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
//        int width = bitmap1.getWidth();
//        int height = bitmap2.getHeight();
//
//        setMeasuredDimension(width,height);
        Rect rect = new Rect(0,0,getMeasuredWidth(),getMeasuredHeight());
        backDrawable.setBounds(rect);
        frontDrawable.setBounds(rect);
    }

//    @Override
//    protected void onDraw(Canvas canvas) {
//        super.onDraw(canvas);
//        camera.save();
//        float degree = this.degree;
//        if(degree>90){
//            degree +=180;
//        }
//        camera.rotateY(degree);
//        camera.getMatrix(matrix);
//        camera.restore();
//        matrix.preTranslate(-getWidth()/2,0);
//        matrix.postTranslate(getWidth()/2,0);
//        if(degree<90){
//            canvas.drawBitmap(frontBitmap,matrix,paint);
//        }else {
//            canvas.drawBitmap(backBitmap,matrix,paint);
//        }
//    }


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
            frontDrawable.draw(canvas);
//            canvas.drawBitmap(frontDrawable,matrix,paint);
        }else {
            backDrawable.draw(canvas);
//            canvas.drawBitmap(backDrawable,matrix,paint);
        }
    }
}
