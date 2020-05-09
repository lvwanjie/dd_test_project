package com.example.myapplication.bujuTest;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.Spanned;
import android.text.style.AbsoluteSizeSpan;
import android.util.Log;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.myapplication.MyUtils;
import com.example.myapplication.R;

public class BuJuActivity extends Activity {

    private static final String TAG = "BuJuActivity";
    // layout_constraintWidth_default get属性
    ImageView imageView ;
    TextView textView;
    private LinearLayout lyContent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bu_ju);
//        imageView = findViewById(R.id.image);
//        Glide.with(this).load("http://file02.16sucai.com/d/file/2014/0704/e53c868ee9e8e7b28c424b56afe2066d.jpg").into(imageView);
//        textView = findViewById(R.id.text2);
//        testSpanner();
//
//        LinearLayout linearLayout = findViewById(R.id.ly_content);
//        LayoutInflater.from(this).inflate(R.layout.activity_buju1,linearLayout,true);
//        lyContent = findViewById(R.id.ly_test_width);
//        lyContent.getLayoutParams().width = 100;
//        Log.i(TAG, "onCreate: "+lyContent.getLayoutParams().width);
//        lyContent.post(new Runnable() {
//            @Override
//            public void run() {
//                Log.i(TAG, "onCreate:width = "+lyContent.getWidth());
//                Log.i(TAG, "onCreate:paramsWidth = "+lyContent.getLayoutParams().width);
//            }
//        });

    }


    public  void testSpanner(){
//        SpannableString string = new SpannableString("安保擦拔插");
//        string.setSpan(new AbsoluteSizeSpan(MyUtils.dp2Px(this,11)),0,3, Spanned.SPAN_INCLUSIVE_EXCLUSIVE);
//        textView.setText(string);
    }
}
