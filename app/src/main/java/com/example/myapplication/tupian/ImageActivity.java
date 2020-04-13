package com.example.myapplication.tupian;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.engine.GlideException;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.RequestOptions;
import com.bumptech.glide.request.target.CustomTarget;
import com.bumptech.glide.request.target.SimpleTarget;
import com.bumptech.glide.request.target.Target;
import com.bumptech.glide.request.transition.Transition;
import com.example.myapplication.R;

import static androidx.constraintlayout.widget.Constraints.TAG;

public class ImageActivity extends Activity {

    private ImageView imageView;
    private String str = "http://img7x3.ddimg.cn/Community71/95/11/17015423-reviewimg-1_o.jpg";
    private ImageView imageView2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image);
        imageView = findViewById(R.id.image_view);
        imageView2 = findViewById(R.id.image_view2);
        BitmapDrawable bitmapDrawable = (BitmapDrawable) imageView2.getDrawable();
        RequestOptions options = new RequestOptions().placeholder(-1);
        Glide.with(this).load(str).apply(options).listener(new RequestListener<Drawable>() {
            @Override
            public boolean onLoadFailed(@Nullable GlideException e, Object model, Target<Drawable> target, boolean isFirstResource) {
                Log.i(TAG, "onLoadFailed: ");
                return false;
            }

            @Override
            public boolean onResourceReady(Drawable resource, Object model, Target<Drawable> target, DataSource dataSource, boolean isFirstResource) {
                BitmapDrawable bitmapDrawable = (BitmapDrawable) resource;
                Bitmap bitmap = bitmapDrawable.getBitmap();
                Log.i(TAG, "onResourceReady: ");

                return false;
            }
        }).into(imageView);
        Glide.with(this)
                .load(str).into(new CustomTarget<Drawable>() {
            @Override
            public void onResourceReady(@NonNull Drawable resource, @Nullable Transition<? super Drawable> transition) {
                ((BitmapDrawable)resource).getIntrinsicWidth();
                Log.i(TAG, "onResourceReady: ");
            }

            @Override
            public void onLoadCleared(@Nullable Drawable placeholder) {
                Log.i(TAG, "onLoadCleared: ");
            }
        });
    }



}
