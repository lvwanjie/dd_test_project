package com.example.myapplication.draw;

import android.app.Activity;
import android.graphics.Color;
import android.graphics.Outline;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.ViewOutlineProvider;
import android.widget.ImageView;

import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;

import com.example.myapplication.R;

public class ShadowDrawActivity extends Activity {

    private ImageView imageView;

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shadow_draw);
        imageView = findViewById(R.id.image_view);

        ColorDrawable colorDrawable = new ColorDrawable();
        colorDrawable.setColor(Color.parseColor("#78c5f2"));
        MyShadowDrawableWrapper shadowDrawableWrapper = new MyShadowDrawableWrapper(this,colorDrawable,100,10,100);
//        imageView.setBackgroundDrawable(shadowDrawableWrapper);
        imageView.setOutlineProvider(new ViewOutlineProvider() {
            @Override
            public void getOutline(View view, Outline outline) {
//                outline.
            }
        });
    }
}
