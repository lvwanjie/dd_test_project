package com.example.myapplication.draw;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.graphics.Canvas;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;

import com.example.myapplication.R;

public class DrawActivity extends Activity {

    public LinearLayout linearLayout;
    private String TAG = "DrawActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_draw);
        Canvas canvas;
        linearLayout = findViewById(R.id.text_ly);
    }


    public void btClick(View view){
        int width = linearLayout.getWidth();
        int measureWidth = linearLayout.getMeasuredWidth();
        int paramsWidth = linearLayout.getLayoutParams().width;
        try{
            Float f = Float.parseFloat("ab");

        }catch (Exception e){
            e.printStackTrace();
        }
        Log.i(TAG, "btClick: width =  " +width +";   measureWidth = " +measureWidth +"；   paramsWidth="+ paramsWidth);
    }
}
