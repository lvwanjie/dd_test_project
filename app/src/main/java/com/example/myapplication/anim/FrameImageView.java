package com.example.myapplication.anim;

import android.content.Context;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.Log;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatImageView;


public class FrameImageView  extends AppCompatImageView {

    private String TAG = "FrameImageView";
    public FrameImageView(Context context) {
        super(context);
    }

    public FrameImageView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    public void invalidateDrawable(@NonNull Drawable dr) {
        super.invalidateDrawable(dr);
        Log.i(TAG, "invalidateDrawable: ");
        AnimationDrawable animationDrawable = (AnimationDrawable)getDrawable();
        animationDrawable.getNumberOfFrames();

    }
}
