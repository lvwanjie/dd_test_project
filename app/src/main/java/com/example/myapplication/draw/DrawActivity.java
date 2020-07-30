package com.example.myapplication.draw;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Canvas;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.example.myapplication.R;
import com.example.myapplication.utils.CustomRoundAngleImageView;

public class DrawActivity extends Activity implements View.OnClickListener{

    public LinearLayout linearLayout;
    private String TAG = "DrawActivity";
    private DrawView drawView;
    private ImageView imageView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_draw);
        Canvas canvas;
        linearLayout = findViewById(R.id.text_ly);
        drawView = findViewById(R.id.draw_view);
        imageView = findViewById(R.id.civ_image);
        RequestOptions requestOptions = new RequestOptions();
//        requestOptions.error(R.drawable.aaa);
        Glide.with(this).applyDefaultRequestOptions(requestOptions).load("http://img3m1.ddimg.cn/57/10/23762631-1_m.jpg").into(imageView);
    }


    public void btClick(View view){
//        int width = linearLayout.getWidth();
//        int measureWidth = linearLayout.getMeasuredWidth();
//        int paramsWidth = linearLayout.getLayoutParams().width;
//        try{
//            Float f = Float.parseFloat("ab");
//
//        }catch (Exception e){
//            e.printStackTrace();
//        }
//        Log.i(TAG, "btClick: width =  " +width +";   measureWidth = " +measureWidth +"；   paramsWidth="+ paramsWidth);

        drawView.setVisibility(View.GONE);
        drawView.setVisibility(View.VISIBLE);
        drawView.setVisibility(View.GONE);
        drawView.setVisibility(View.VISIBLE);
        drawView.setVisibility(View.GONE);

        Intent intent = new Intent(this,FadeTestActivity.class);
        startActivity(intent);
        LinearLayout linearLayout;
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.action_settings:break;
        }
    }
}
