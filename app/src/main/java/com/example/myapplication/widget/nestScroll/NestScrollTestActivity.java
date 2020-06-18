package com.example.myapplication.widget.nestScroll;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.widget.LinearLayout;

import com.example.myapplication.R;
import com.example.myapplication.pubulayout.TestRecyclerAdapter;

public class NestScrollTestActivity extends Activity {

    private RecyclerView recyclerView;
    private WebView webView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nest_scroll_test);
        recyclerView = findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(new TestRecyclerAdapter(this));
        webView = findViewById(R.id.web_view);
        webView.loadUrl("file:////android_asset/xieyi.html");
    }
}
