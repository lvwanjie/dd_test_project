package com.example.myapplication.launchMode;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.Window;

import com.example.myapplication.R;

public class TestLaunchModeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_launch_mode);
        Window window = getWindow();
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            window.setStatusBarColor(Color.parseColor("#ffffff"));

        }

    }

    public void btClick(View view){
        Intent intent = new Intent(this,LMSingleInstanceActivity.class);
        startActivity(intent);
    }
}
