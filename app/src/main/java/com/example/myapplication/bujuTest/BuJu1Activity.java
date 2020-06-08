package com.example.myapplication.bujuTest;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.ImageSpan;
import android.widget.TextView;

import com.example.myapplication.MyUtils;
import com.example.myapplication.R;

public class BuJu1Activity extends Activity {

    private TextView tvSpan;
    private TextView tvSpan1;
    private ImageSpan imageSpan;
    private SpannableString spannableString;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buju1);
        tvSpan = findViewById(R.id.text_span);
        tvSpan1 = findViewById(R.id.text_span1);
        tvSpan.setText(getPriceSpanStr(""));
        getImageSpanStr("一二三四五六七");
        SpannableString spannableString1 = new SpannableString("一二三四五六七");
        spannableString1.setSpan(imageSpan,0,1, Spannable.SPAN_INCLUSIVE_EXCLUSIVE);
        SpannableString spannableString2 = new SpannableString("一二三四五六七");
        spannableString2.setSpan(imageSpan,0,1, Spannable.SPAN_INCLUSIVE_EXCLUSIVE);
        tvSpan.setText(spannableString1);
        tvSpan1.setText(spannableString2);
    }

    private SpannableString getPriceSpanStr(String priceStr){
        String newStr = "￥"+priceStr;
        int dotIndex = newStr.indexOf(".");
        SpannableString spannableString = new SpannableString(newStr);
        spannableString.setSpan(new AbsoluteSizeSpan(MyUtils.dp2Px(this,11)),0,1, Spanned.SPAN_INCLUSIVE_EXCLUSIVE);
        if(dotIndex >0){
            spannableString.setSpan(new AbsoluteSizeSpan(MyUtils.dp2Px(this,18)),1,dotIndex+1, Spanned.SPAN_INCLUSIVE_EXCLUSIVE);
            spannableString.setSpan(new AbsoluteSizeSpan(MyUtils.dp2Px(this,14)),dotIndex,newStr.length(), Spanned.SPAN_INCLUSIVE_EXCLUSIVE);
        }else {
            spannableString.setSpan(new AbsoluteSizeSpan(MyUtils.dp2Px(this,18)),1,newStr.length(), Spanned.SPAN_INCLUSIVE_EXCLUSIVE);
        }
        System.out.println("");

        return spannableString;

    }


    private void getImageSpanStr(String str){
        Bitmap bitmap = BitmapFactory.decodeResource(getResources(),R.drawable.topic);
        Drawable drawable = new BitmapDrawable(bitmap);
        drawable.setBounds(new Rect(0,0,40,40));
        imageSpan = new ImageSpan(drawable);
        spannableString = new SpannableString(str);
        spannableString.setSpan(imageSpan,0,1, Spannable.SPAN_INCLUSIVE_EXCLUSIVE);

    }
}
