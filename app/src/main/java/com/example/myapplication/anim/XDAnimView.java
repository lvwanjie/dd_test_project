package com.example.myapplication.anim;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.graphics.drawable.AnimationDrawable;
import android.os.Handler;
import android.os.Looper;
import android.util.AttributeSet;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.widget.FrameLayout;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.myapplication.R;

public class XDAnimView extends FrameLayout {

    private FrameLayout frameLayout;
    private ImageView ivBack;
    private ImageView ivFont;
    private ImageView ivBelow;
    private AnimationDrawable animationDrawable;
    private AnimationDrawable belowAnimDrawable;

    public XDAnimView(@NonNull Context context) {
        super(context);
        init();
    }

    public XDAnimView(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }


    private void init(){
        inflate(getContext(),R.layout.xd_anim_layout,this);
        frameLayout = findViewById(R.id.fl);
        ivBack = findViewById(R.id.iv_back);
        ivFont = findViewById(R.id.iv_font);
        ivBelow = findViewById(R.id.iv_below);
        animationDrawable = (AnimationDrawable) ivFont.getDrawable();
        belowAnimDrawable = (AnimationDrawable) ivBelow.getDrawable();
    }

    public void startAnim(){
        start();
        if(belowAnimDrawable != null){
            belowAnimDrawable.start();
            countToAnimEnd();
        }

    }

    private void start(){
        ObjectAnimator tranAnimator = ObjectAnimator.ofFloat(frameLayout,"translationY",0,-25,-50,-75,-100,-100);
        ObjectAnimator scaleXAnimator = ObjectAnimator.ofFloat(frameLayout,"scaleX",0,1);
        ObjectAnimator scaleYAnimator = ObjectAnimator.ofFloat(frameLayout,"scaleY",0,1);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.setDuration(500);
        animatorSet.setInterpolator(new AccelerateDecelerateInterpolator());
        animatorSet.playTogether(tranAnimator,scaleXAnimator,scaleYAnimator);
        animatorSet.start();


    }

    private Handler handler = new Handler(Looper.getMainLooper());
    private void countToAnimEnd(){
        new Thread(new Runnable() {
            @Override
            public void run() {
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        if(animationDrawable != null){
                            ivFont.setVisibility(VISIBLE);
                            ivBack.setImageResource(R.drawable.done);
                            animationDrawable.start();
                        }
                        ivBelow.setVisibility(GONE);
                    }
                },2500);
            }
        }).start();

    }
}
