package com.example.myapplication.zhedielayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;
import androidx.viewpager.widget.ViewPager;

import android.app.Activity;
import android.graphics.Color;
import android.graphics.drawable.AnimationDrawable;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

import com.example.myapplication.R;
import com.example.myapplication.pubulayout.PubuAdapter;
import com.google.android.material.appbar.AppBarLayout;

import java.util.ArrayList;
import java.util.List;


/**
 * 吸顶布局测试
 */

public class MountingActivity extends FragmentActivity {

    private RecyclerView recyclerView;
    private AppBarLayout appBarLayout;
    private String TAG ="MountingActivity";
    private ViewPager viewPager;
    private Fragment fragmentA;
    private Fragment fragmentB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);

        setContentView(R.layout.activity_mounting);
        getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN | View.SYSTEM_UI_FLAG_LAYOUT_STABLE);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            getWindow().setStatusBarColor(Color.TRANSPARENT);
        }
        recyclerView = findViewById(R.id.recycler_view);
        appBarLayout = findViewById(R.id.app_bar_layout);
        viewPager = findViewById(R.id.view_pager);
        fragmentA = MyFragment.getInstance();
        fragmentB = MyFragment.getInstance();
        List list = new ArrayList();
        list.add(fragmentA);
        list.add(fragmentB);
        MyVpAdapter myVpAdapter = new MyVpAdapter(getSupportFragmentManager(),0);
        myVpAdapter.setData(list);
        viewPager.setAdapter(myVpAdapter);
        StaggeredGridLayoutManager staggeredGridLayoutManager = new StaggeredGridLayoutManager(2,RecyclerView.VERTICAL);
        recyclerView.setLayoutManager(staggeredGridLayoutManager);
        PubuAdapter pubuAdapter = new PubuAdapter(this,staggeredGridLayoutManager);
        recyclerView.setAdapter(pubuAdapter);
        appBarLayout.addOnOffsetChangedListener(new AppBarLayout.BaseOnOffsetChangedListener() {
            @Override
            public void onOffsetChanged(AppBarLayout appBarLayout, int i) {
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                    Log.i(TAG, "onOffsetChanged: "+appBarLayout.getElevation());
                }
            }
        });




    }

    @Override
    protected void onDestroy() {
        finish();
        super.onDestroy();
    }
}
