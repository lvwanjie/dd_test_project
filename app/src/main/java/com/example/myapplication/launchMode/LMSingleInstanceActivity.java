package com.example.myapplication.launchMode;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;

import com.example.myapplication.R;

public class LMSingleInstanceActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lmsingle_instance);

    }

    public void btClick(View view){
        Intent intent = new Intent(this,LMSingleTaskActivity.class);
        startActivity(intent);
        Window window =  null;
    }
}
