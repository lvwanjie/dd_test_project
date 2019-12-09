package com.example.myapplication;

import android.content.Context;
import android.content.res.Resources;

public class MyUtils {


    public static int getStatusBarHeight(Context context) {
        Resources resources = context.getResources();
        int resourceId = resources.getIdentifier("status_bar_height", "dimen", "android");
        int height = resources.getDimensionPixelSize(resourceId);
        return height;
    }

    public static int dp2Px(Context mContext, int dp) {
        final float scale = mContext.getResources ().getDisplayMetrics ().density;
        return (int) (dp * scale + 0.5f);
    }

}
