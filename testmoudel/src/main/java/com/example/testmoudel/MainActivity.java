package com.example.testmoudel;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.mylibrary.TestMaven;

public class MainActivity extends Activity implements View.OnClickListener {

    TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = findViewById(R.id.text_view);
        textView.setOnClickListener(this);
        TestMaven.doSometing();
    }

    @Override
    public void onClick(View v) {
        int a =0;
        if (v.getId() == R.id.text_view) {
        }
    }
}
