package com.example.myapplication.testFragment;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;

import com.example.myapplication.R;

public class TestFragmentActivity extends FragmentActivity {

    private TestFragment testFragment;
    private TestFragment testFragment1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_fragment);
        testFragment = TestFragment.newInstance("a","a");
        testFragment1 = TestFragment.newInstance("a","a");
        getSupportFragmentManager().beginTransaction().replace(R.id.fl_content,testFragment).commit();
    }

    public void replace(View view){
        getSupportFragmentManager().beginTransaction().replace(R.id.fl_content,testFragment1).commit();
    }
}
