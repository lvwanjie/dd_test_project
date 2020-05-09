package com.example.myapplication.widget.editText;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.text.Editable;
import android.text.InputFilter;
import android.text.Spanned;
import android.text.TextWatcher;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.EditText;
import android.widget.TextView;

import com.example.myapplication.MyUtils;
import com.example.myapplication.R;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

public class EditInputFilterActivity extends Activity {

    private EditText editText;
    private String TAG = "EditInputFilterActivity";
    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_input_filter);
        editText = findViewById(R.id.edit);
        textView = findViewById(R.id.text_view);
        AtomicInteger atomicInteger;
        int dp8 = MyUtils.dp2Px(this,8);
        ShapeBuilder.create ().RoundRadius ( dp8 , dp8 ,  dp8 , dp8 ).
                Soild (Color.parseColor("#f3f3f3")).build (editText);
                int dp2 = MyUtils.dp2Px(this,2);
        ShapeBuilder.create ().RoundRadius ( dp2 , dp2 ,  dp2 , dp2 ).
                Soild (Color.parseColor("#DCDCDC")).build (textView);

        HashMap hashMap= new HashMap();

        hashMap.put("","");

        Map map =  Collections.synchronizedMap(new HashMap<>());
        hashMap.containsKey("");
        editText.setFilters(new InputFilter[]{new InputFilter.LengthFilter(10),
                new InputFilter() {
            @Override
            public CharSequence filter(CharSequence source, int start, int end, Spanned dest, int dstart, int dend) {
                Log.i(TAG, "filter: source="+source+";start="+start+";end="+end+";dest="+dest+";dstart="+dstart+";dend="+dend);
                return null;
            }
        }});

        editText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                Log.i(TAG, "beforeTextChanged: ");
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                Log.i(TAG, "onTextChanged: ");
            }

            @Override
            public void afterTextChanged(Editable s) {
                Log.i(TAG, "afterTextChanged: ");
            }
        });

//        editText.

//        editText.setOnEditorActionListener(new TextView.OnEditorActionListener() {
//            @Override
//            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
//                switch(actionId){
//                    case EditorInfo.IME_ACTION_DONE:
//                        Log.i(TAG, "onEditorAction: "+EditorInfo.IME_ACTION_DONE);
//                        return true;
//                }
//                return false;
//            }
//        });

        editText.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                Log.i(TAG, "onKey: keyCode="+keyCode);
                return false;
            }
        });
    }
}
