package com.example.myapplication.bujuTest;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.os.Bundle;
import android.text.SpannableString;
import android.widget.TextView;

import com.example.myapplication.R;

public class BUJU2Activity extends Activity {

    private TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buju2);
        textView =findViewById(R.id.tv2);
        textView.setText(getString());
    }

    public SpannableString getString(){
        SpannableString spannableString = new SpannableString("有效期至sssssssssssssdfsdfsfsssssssssssssdfsdfsfsssssssssssssdfsdfsf");

        return spannableString;
    }
}
