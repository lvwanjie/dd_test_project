package com.example.myapplication.zhedielayout;

import android.os.Build;
import android.os.Bundle;

import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.widget.NestedScrollView;

import android.util.Log;
import android.view.View;

import com.example.myapplication.R;

public class ScrollingActivity2 extends AppCompatActivity {

    private CoordinatorLayout coordinatorLayout;
    private AppBarLayout appBarLayout;
    private NestedScrollView scrollView;
    private String TAG ="ScrollingActivity2";

    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scrolling2);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        coordinatorLayout = findViewById(R.id.coordinator_layout);
        appBarLayout = findViewById(R.id.app_bar);
        scrollView = findViewById(R.id.scroll_view);
        appBarLayout.addOnOffsetChangedListener(new AppBarLayout.OnOffsetChangedListener() {
            @Override
            public void onOffsetChanged(AppBarLayout appBarLayout, int i) {
                Log.i(TAG, "onOffsetChanged: i="+i);
            }
        });
        appBarLayout.setOnScrollChangeListener(new View.OnScrollChangeListener() {
            @Override
            public void onScrollChange(View v, int scrollX, int scrollY, int oldScrollX, int oldScrollY) {
                Log.i(TAG, "appBarLayout:>>>>>>>>onScrollChange: scrollX="+scrollX+";scrollY="+scrollY+";oldScrollX="+oldScrollX+";oldScrollY="+oldScrollY);
            }
        });

//        scrollView.offsetTopAndBottom();

        scrollView.setOnScrollChangeListener(new View.OnScrollChangeListener() {
            @Override
            public void onScrollChange(View v, int scrollX, int scrollY, int oldScrollX, int oldScrollY) {
                Log.i(TAG, "scrollView:<<<<<<<<<<<onScrollChange: scrollX="+scrollX+";scrollY="+scrollY+";oldScrollX="+oldScrollX+";oldScrollY="+oldScrollY);
            }
        });




    }
}
