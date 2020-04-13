package com.example.myapplication.draw;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.widget.LinearLayout;

import com.example.myapplication.R;

public class InvalidateTestActivity extends Activity {

    private LinearLayout lyRed;
    private LinearLayout lyBlack;
    private LinearLayout lyRoot;
    private DrawView drawView;
    private DrawView drawView1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_invalidate_test);
        lyRed = findViewById(R.id.ly_red);
        lyBlack = findViewById(R.id.ly_black);
        drawView = findViewById(R.id.draw_view);
        drawView1 = findViewById(R.id.draw_view1);
        lyRoot = findViewById(R.id.root);
        lyRed.postDelayed(new Runnable() {
            @Override
            public void run() {
                lyRed.getLayoutParams().height += 1000;
                lyRoot.invalidate();

            }
        },2000);
    }
}
