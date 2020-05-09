package com.example.myapplication.anim;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.app.Activity;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.Drawable;
import android.media.Image;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.Animation;
import android.widget.FrameLayout;
import android.widget.ImageView;

import com.example.myapplication.R;

import static androidx.constraintlayout.widget.Constraints.TAG;

public class HpAnimActivity extends Activity {

    private static final  String TAG = "HpAnimActivity";
    private FrameLayout frameLayout;
    private ImageView ivBack;
    private ImageView ivFont;
    private ImageView ivFrame;
    private ImageView ivBelow;
    private AnimationDrawable animationDrawable;
    private AnimationDrawable belowAnimDrawable;
    private Animation animation;

    private AnimationDrawable animationDrawable1; //
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hp_anim);
        frameLayout = findViewById(R.id.fl);
        ivBack = findViewById(R.id.iv_back);
        ivFont = findViewById(R.id.iv_font);
        ivFrame = findViewById(R.id.iv_frame);
        ivBelow = findViewById(R.id.iv_below);
        animationDrawable = (AnimationDrawable) ivFont.getDrawable();
        belowAnimDrawable = (AnimationDrawable) ivBelow.getDrawable();



        animationDrawable1 = (AnimationDrawable) ivFrame.getDrawable(); //

    }


    public void startAnim(View view){
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

    public void countToAnimEnd(){
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                if(animationDrawable != null){
                    ivFont.setVisibility(View.VISIBLE);
                    ivBack.setImageResource(R.drawable.done);
                    animationDrawable.start();
                }
            }
        },2500);
    }
}
