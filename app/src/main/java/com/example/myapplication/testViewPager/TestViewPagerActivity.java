package com.example.myapplication.testViewPager;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;

import com.example.myapplication.R;

import java.util.ArrayList;
import java.util.List;

public class TestViewPagerActivity extends AppCompatActivity {

    private ViewPager viewPager;
    private TestVpAdapter vpAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_view_pager);
        viewPager = findViewById(R.id.view_pager);
//        viewPager.setAdapter();

    }

    public List getFakeData(int index){
        List<String> list = new ArrayList<>();
        for(int i=0;i<5;i++){
            list.add("item"+i+";index="+index);
        }
        return list;
    }



}
