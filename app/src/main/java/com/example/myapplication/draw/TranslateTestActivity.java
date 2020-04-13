package com.example.myapplication.draw;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.LinearLayout;

import com.example.myapplication.R;

public class TranslateTestActivity extends AppCompatActivity {

    private LinearLayout ly1;
    private LinearLayout ly2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_translate_test);
        ly1 = findViewById(R.id.ly1);
        ly2 = findViewById(R.id.ly2);
        ly1.setTranslationX(100);
        ly2.setScrollX(120);

    }
}
