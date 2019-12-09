package com.example.myapplication.windows;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.WindowManager;

import com.example.myapplication.R;

public class TestWindowActivity extends AppCompatActivity {

    private WindowManager windowManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_window);
        windowManager = getWindowManager();
        View view = View.inflate(this,R.layout.window_view_layout,null);
        WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams();
//        layoutParams.flags = WindowManager.LayoutParams.Flagtouc
//        windowManager.addView(view,);
    }
}
