package com.example.myapplication.widget.editText;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.text.Editable;
import android.text.InputFilter;
import android.text.Spanned;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.myapplication.MyUtils;
import com.example.myapplication.R;

import java.io.UnsupportedEncodingException;
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
        Glide.with(this).load("").into(new ImageView(this));
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
        editText.setFilters(new InputFilter[]{new MyMaxLengthInputFilter1(10),
                new InputFilter() {
            @Override
            public CharSequence filter(CharSequence source, int start, int end, Spanned dest, int dstart, int dend) {
                for (int i=0;i<source.length();i++){
                    char c= source.charAt(i);
                    if(c>='\u4E00' && c<='\u9FA5'){
                        Log.i(TAG, "myInputFilter: "+c+"是汉字");
                    }else {

                    }

                }
                Log.i(TAG, "filter: source="+source+";start="+start+";end="+end+";dest="+dest+";dstart="+dstart+";dend="+dend);
                return null;
            }
        }});

        editText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                Log.i(TAG, "beforeTextChanged: s="+s+"；start="+start+";count="+count+";after="+after);
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                Log.i(TAG, "onTextChanged: s="+s+";start="+start);
            }

            @Override
            public void afterTextChanged(Editable s) {
                Log.i(TAG, "afterTextChanged: s="+s);
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

    public static class MyMaxLengthInputFilter implements InputFilter {

        private int max;

        public MyMaxLengthInputFilter(int max){
            this.max = max;
        }

        @Override
        public CharSequence filter(CharSequence source, int start, int end, Spanned dest, int dstart, int dend) {
            int sourceLength = getStrLength(TextUtils.isEmpty(source)?"":source.toString());
            int destLength = getStrLength(TextUtils.isEmpty(dest)?"":dest.toString());
            int keep = max -destLength;
            if(keep <= 0){
                return "";
            }else if(keep >=sourceLength){
                return null;
            }else {
                StringBuilder strBuild = new StringBuilder();
                int sourceIndex =0;
                while (true){
                    if(sourceIndex >=sourceLength){
                        break;
                    }
                    char ch = source.charAt(sourceIndex);
                    int charLen = getCharLength(ch);
                    if(keep >=0 && keep >=charLen){
                        strBuild.append(ch);
                        keep -= charLen;
                        sourceIndex ++;
                    }else {
                        break;
                    }
                }
                return strBuild.toString();
//                keep += start;
//                return source.subSequence(start, keep);
            }
        }

        public int getCharLength(char ch){
            if(ch >= '\u4E00' && ch <= '\u9FA5'){
                return 2;
            }else {
               return 1;
            }
        }

        //获取字符串的长度，汉字算两个字符
        public int getStrLength(String str){
            if(TextUtils.isEmpty(str)){
                return 0;
            }
            try {
                String tempName = new String(str.getBytes("GBK"), "iso-8859-1");
                return tempName.length();
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
            return str.length();

        }
    }


    public static class MyMaxLengthInputFilter1 implements InputFilter{

        private final int mMax;
        private String TAG ="MyMaxLengthInputFilter1";

        public MyMaxLengthInputFilter1(int max) {
            mMax = max;
        }

        public CharSequence filter(CharSequence source, int start, int end, Spanned dest,
                                   int dstart, int dend) {
            int keep = mMax - (dest.length() - (dend - dstart));
            if (keep <= 0) {
                return "";
            } else if (keep >= end - start) {
                return null; // keep original
            } else {
                keep += start;
//                if (Character.isHighSurrogate(source.charAt(keep - 1))) {
//                    --keep;
//                    if (keep == start) {
//                        return "";
//                    }
//                }
               CharSequence charSequence =  source.subSequence(start, keep);
                Log.i(TAG, "filter: start = "+ start +";keep="+keep+";charSequence="+charSequence);
                return charSequence;
            }
        }

        /**
         * @return the maximum length enforced by this input filter
         */
        public int getMax() {
            return mMax;
        }

    }

    public static class MyMaxLengthInputFilter2 implements InputFilter {

        private int max;
        private String TAG ="MyMaxLengthInputFilter2";

        public MyMaxLengthInputFilter2(int max){
            this.max = max;
        }

        @Override
        public CharSequence filter(CharSequence source, int start, int end, Spanned dest, int dstart, int dend) {
            int sourceLength = getStrLength(TextUtils.isEmpty(source)?"":source.toString());
            int destLength = getStrLength(TextUtils.isEmpty(dest)?"":dest.toString());
            int keep = max -(destLength  - (dend - dstart));
            if(keep <= 0){
                return "";
            }else if(keep >=sourceLength){
                return null;

            }else {
                int sourceIndex =start;
                while (keep >0){
                    if(sourceIndex >= source.length()){
                        break;
                    }
                    char ch = source.charAt(sourceIndex);
                    int charLen = getCharLength(ch);
                    keep -= charLen;
                    sourceIndex++;
                }
                CharSequence charSequence =source.subSequence(start, sourceIndex);
                Log.i(TAG, "subSequence: start="+start+";sourceIndex="+sourceIndex+";charSequence="+charSequence);
                return charSequence;
            }
        }

        public int getCharLength(char ch){
            if(ch >= '\u4E00' && ch <= '\u9FA5'){
                return 2;
            }else {
                return 1;
            }
        }

        //获取字符串的长度，汉字算两个字符
        public int getStrLength(String str){
            if(TextUtils.isEmpty(str)){
                return 0;
            }
            try {
                String tempName = new String(str.getBytes("GBK"), "iso-8859-1");
                return tempName.length();
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
            return str.length();

        }
    }

}
