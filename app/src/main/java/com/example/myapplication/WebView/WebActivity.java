package com.example.myapplication.WebView;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.webkit.WebView;

import com.example.myapplication.R;

public class WebActivity extends Activity {

    private WebView webView;
    private String TAG="WebActivity.java";

    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web);
        webView = findViewById(R.id.web_view);
        webView.loadUrl("file:////android_asset/xieyi.html");
        webView.setOnScrollChangeListener(new View.OnScrollChangeListener() {
            @Override
            public void onScrollChange(View v, int scrollX, int scrollY, int oldScrollX, int oldScrollY) {
                Log.i(TAG, "onScrollChange: ");
            }
        });

    }
}
