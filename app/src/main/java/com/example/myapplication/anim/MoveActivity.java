package com.example.myapplication.anim;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.Log;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;

import com.example.myapplication.R;

import static androidx.constraintlayout.widget.Constraints.TAG;

public class MoveActivity extends Activity {

    private ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_move);
        imageView = findViewById(R.id.iv);
        imageView.setBackgroundResource(R.drawable.bg_shape_conner_radius8);
        Drawable drawable = imageView.getBackground();
        Log.i(TAG, "onCreate: ");
    }
}
