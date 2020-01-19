package com.example.myapplication.bujuTest;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.coordinatorlayout.widget.CoordinatorLayout;

import com.example.myapplication.R;

public class CustomView extends ConstraintLayout {

    public CustomView(@NonNull Context context) {
        super(context);
        init();
    }

    public CustomView(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();

    }

    public CustomView(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }


    public void init(){
        LayoutInflater.from(getContext()).inflate(R.layout.buju_merge_layout,this,true);
//        View view = LayoutInflater.from(getContext()).inflate(R.layout.buju_merge_layout,this,false);
        Log.i("", "init: ");
    }
}
