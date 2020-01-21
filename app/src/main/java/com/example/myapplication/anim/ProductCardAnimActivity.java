package com.example.myapplication.anim;

import androidx.appcompat.app.AppCompatActivity;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.app.Activity;
import android.graphics.Camera;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.AnimationUtils;
import android.view.animation.RotateAnimation;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.myapplication.R;

public class ProductCardAnimActivity extends Activity {

    private LinearLayout lyAnim1;
    private ImageView lyAnim2;
    boolean isPickUp;
    private LinearLayout lyAnimator;
    private Card3dView card3dView;
    private Animator animatorIn;
    private Animator animatorOut;
    private TextView textView1;
    private CardRotateView cardRotateView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_card_anim);
        lyAnim1 = findViewById(R.id.ly_anim1);
        lyAnim2 = findViewById(R.id.ly_anim2);
        lyAnimator = findViewById(R.id.ly_animator);
        card3dView = findViewById(R.id.card3dView);
        textView1 = findViewById(R.id.text_1);
        cardRotateView = findViewById(R.id.card_rotate_view);
//        cardRotateView.setBitmapResources(R.mipmap.icon_dangdu_card_pack_up,R.mipmap.icon_dangdu_card_spread_out);
        textView1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(ProductCardAnimActivity.this,"aaaaa",Toast.LENGTH_SHORT).show();
            }
        });
        lyAnimator.post(new Runnable() {
            @Override
            public void run() {
                animatorIn = getAnimator(true);
                animatorOut = getAnimator(false);
            }
        });
    }

    public void startAnim(){
        ObjectAnimator objectAnimator = ObjectAnimator.ofFloat(lyAnim1,"scaleX",0,1);

        objectAnimator.start();
    }

    public void setAnim1(){
        Animation animation = AnimationUtils.loadAnimation(this,R.anim.anim_scale);
        lyAnim1.startAnimation(animation);
    }

    public void setAnim2(){
        int width = lyAnim2.getWidth();
        int height = lyAnim1.getHeight();

         Rotate3dAnimation animation = new Rotate3dAnimation(0,180,width/2,height/2,0,false);

         animation.setStartOffset(1000);
        animation.setDuration(300);
        animation.setMidListener(new Rotate3dAnimation.MidListener() {
            @Override
            public void onMid() {
                if(isPickUp){
                    isPickUp = false;
                    lyAnim2.setImageResource(R.mipmap.icon_dangdu_card_pack_up);
                }else {
                    isPickUp = true;
                    lyAnim2.setImageResource(R.mipmap.icon_dangdu_card_spread_out);

                }
            }
        });

        Animation animation1 = AnimationUtils.loadAnimation(this,R.anim.anim_sacle_1);
        AnimationSet animationSet = new AnimationSet(true);
        animationSet.addAnimation(animation1);
        animationSet.addAnimation(animation);

        lyAnim2.startAnimation(animationSet);
    }


    public Animator getAnimator(boolean isShow){
        AnimatorSet animatorSet = new AnimatorSet();
        ObjectAnimator scaleXAnimator ;
        ObjectAnimator scaleYAnimator ;
        if(!isShow){
             scaleXAnimator = ObjectAnimator.ofFloat(lyAnimator,"scaleX",0,1);
             scaleYAnimator = ObjectAnimator.ofFloat(lyAnimator,"scaleY",0,1);
             animatorSet.addListener(new AnimatorListenerAdapter() {
                 @Override
                 public void onAnimationEnd(Animator animation) {
                     super.onAnimationEnd(animation);


                 }
             });
        }else {
            scaleXAnimator = ObjectAnimator.ofFloat(lyAnimator,"scaleX",1,0);
            scaleYAnimator = ObjectAnimator.ofFloat(lyAnimator,"scaleY",1,0);
            animatorSet.addListener(new AnimatorListenerAdapter() {
                @Override
                public void onAnimationEnd(Animator animation) {
                    super.onAnimationEnd(animation);
                    lyAnimator.setVisibility(View.GONE);
                }
            });
        }
        lyAnimator.setPivotX(lyAnimator.getWidth());
        lyAnimator.setPivotY(lyAnimator.getHeight()/2);
        animatorSet.playTogether(scaleXAnimator,scaleYAnimator);
        animatorSet.setInterpolator(new AccelerateInterpolator());
        animatorSet.setDuration(500);
        return animatorSet;
    }




    public void btClick(View view){
//       setAnim1();
//       setAnim2();
//        if(!card3dView.isRoateBack()){
//          animatorIn.start();
//        }else {
//            lyAnimator.setVisibility(View.VISIBLE);
//            animatorOut.start();
//        }
//       card3dView.startAnim();
//        cardRotateView.startAnim();

        card3dView.scrollBy(10,10);
    }
}
