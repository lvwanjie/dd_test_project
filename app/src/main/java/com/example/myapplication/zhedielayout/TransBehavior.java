package com.example.myapplication.zhedielayout;

import android.bluetooth.BluetoothClass;
import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.coordinatorlayout.widget.CoordinatorLayout;

import com.example.myapplication.MyApplication;
import com.example.myapplication.MyUtils;
import com.example.myapplication.R;
import com.google.android.material.appbar.AppBarLayout;

public class TransBehavior extends CoordinatorLayout.Behavior {

    private String TAG ="TransBehavior";

    public TransBehavior(Context context, AttributeSet attributeSet){
        super(context,attributeSet);
    }

    @Override
    public boolean onDependentViewChanged(@NonNull CoordinatorLayout parent, @NonNull View child, @NonNull View dependency) {

        View bg = child.findViewById(R.id.view_bg);
        TextView textView = child.findViewById(R.id.tv_title);

        float height = 0;
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.JELLY_BEAN) {
            height = bg.getHeight()-bg.getMinimumHeight();
        }else {
            height = bg.getHeight()- MyUtils.dp2Px(MyApplication.getInstance(),66);

        }
        float y = dependency.getY();
        float top = dependency.getTop();
        float translate = dependency.getTranslationY();

        float a =  y/height;
        float b = Math.abs(a);
        if(b>1){
            b = 1;
        }
        Log.i(TAG, "y+top+translate: top=" +top+";y="+y+";translate="+translate);

        Log.i(TAG, "onDependentViewChanged: height=" +height+";y="+y+";b="+b);
        bg.setAlpha(b);
        textView.setAlpha(b);


        return true;
    }




}
