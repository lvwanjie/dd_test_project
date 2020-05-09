package com.example.myapplication.zhedielayout;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.coordinatorlayout.widget.CoordinatorLayout;

import com.google.android.material.appbar.AppBarLayout;

public class AlwaysSnapAppBarLayout extends AppBarLayout {
    public AlwaysSnapAppBarLayout(@NonNull Context context) {
        super(context);
    }

    public AlwaysSnapAppBarLayout(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }


    @Override
    public void onStopNestedScroll(View child) {
        super.onStopNestedScroll(child);
    }
}
