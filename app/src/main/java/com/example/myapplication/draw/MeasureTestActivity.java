package com.example.myapplication.draw;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.widget.NestedScrollView;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.myapplication.R;


public class MeasureTestActivity extends Activity {

    private static String TAG = "MeasureTestActivity.java";
    private LinearLayout lyContent;
    private NestedScrollView nestedScrollView;
    private TextView textView;
    private int[] tvLocation = new int[2];
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_measure_test);
        lyContent = findViewById(R.id.ly_layout);
        Log.i(TAG, "beforeMeasure: measureWidth="+lyContent.getMeasuredWidth()+"   measureHeight="+lyContent.getMeasuredHeight());
        lyContent.measure(0,0);
        Log.i(TAG, "afterMeasure: measureWidth="+lyContent.getMeasuredWidth()+"   measureHeight="+lyContent.getMeasuredHeight());
        nestedScrollView = findViewById(R.id.nested_scroll_view);
        textView = findViewById(R.id.text_view);
        textView.post(new Runnable() {
            @Override
            public void run() {
                textView.getLocationOnScreen(tvLocation);
                Log.i(TAG, "post: textViewOnScreen：x="+tvLocation[0]+"  y="+tvLocation[1]);
            }
        });
        nestedScrollView.setOnScrollChangeListener(new NestedScrollView.OnScrollChangeListener() {
            @Override
            public void onScrollChange(NestedScrollView v, int scrollX, int scrollY, int oldScrollX, int oldScrollY) {
                textView.getLocationOnScreen(tvLocation);
                Log.i(TAG, "onScrollChange: textViewOnScreen：x="+tvLocation[0]+"  y="+tvLocation[1]);
                Log.i(TAG, "onScrollChange:textViewY= "+textView.getY());
                Log.i(TAG, "onScrollChange:textViewTop= "+textView.getTop());
                Log.i(TAG, "onScrollChange: scrollX="+scrollX+" scrollY="+scrollY+"  oldScrollX="+oldScrollX+"  oldScrollY="+oldScrollY);
            }
        });
    }
}
