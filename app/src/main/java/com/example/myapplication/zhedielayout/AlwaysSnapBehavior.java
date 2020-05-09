package com.example.myapplication.zhedielayout;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.math.MathUtils;
import androidx.core.view.ViewCompat;

import com.example.myapplication.R;
import com.google.android.material.appbar.AppBarLayout;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;


public class AlwaysSnapBehavior extends AppBarLayout.Behavior {

    public String TAG = "AlwaysSnapBehavior";
    public AlwaysSnapBehavior(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    public void onStopNestedScroll(CoordinatorLayout coordinatorLayout, AppBarLayout abl, View target, int type) {
        super.onStopNestedScroll(coordinatorLayout, abl, target, type);
//        snapToBottom(coordinatorLayout,abl);
//        try {
//            Class clazz = Class.forName("com.google.android.material.appbar.AppBarLayout$BaseBehavior");
//            Method method = clazz.getDeclaredMethod("snapToChildIfNeeded",CoordinatorLayout.class,AppBarLayout.class);
//            method.invoke(this,coordinatorLayout,abl);
//        } catch (NoSuchMethodException e) {
//            e.printStackTrace();
//        } catch (IllegalAccessException e) {
//            e.printStackTrace();
//        } catch (InvocationTargetException e) {
//            e.printStackTrace();
//        } catch (ClassNotFoundException e) {
//            e.printStackTrace();
//        }
    }

    private void snapToBottom(CoordinatorLayout coordinatorLayout, AppBarLayout abl){
       View viewBg =  abl.findViewById(R.id.view_bg1);
       int offset = -(abl.getTotalScrollRange() -viewBg.getTop());
        Log.i(TAG, "snapToBottom: offset="+offset);
        try {
            Class clazz = Class.forName("com.google.android.material.appbar.AppBarLayout$BaseBehavior");
            Method method = clazz.getDeclaredMethod("animateOffsetTo",CoordinatorLayout.class,AppBarLayout.class,int.class,float.class);
            method.setAccessible(true);
            method.invoke(this,coordinatorLayout,abl,offset,0);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

//    private void snapToChildIfNeeded(CoordinatorLayout coordinatorLayout, AppBarLayout abl) {
//        final int offset = getTopBottomOffsetForScrollingSibling();
//        final int offsetChildIndex = getChildIndexOnOffset(abl, offset);
//        if (offsetChildIndex >= 0) {
//            final View offsetChild = abl.getChildAt(offsetChildIndex);
//            final AppBarLayout.LayoutParams lp = (AppBarLayout.LayoutParams) offsetChild.getLayoutParams();
//            final int flags = lp.getScrollFlags();
//
//            if ((flags & AppBarLayout.LayoutParams.FLAG_SNAP) == AppBarLayout.LayoutParams.FLAG_SNAP) {
//                // We're set the snap, so animate the offset to the nearest edge
//                int snapTop = -offsetChild.getTop();
//                int snapBottom = -offsetChild.getBottom();
//
//                if (offsetChildIndex == abl.getChildCount() - 1) {
//                    // If this is the last child, we need to take the top inset into account
//                    snapBottom += abl.getTopInset();
//                }
//
//                if (checkFlag(flags, AppBarLayout.LayoutParams.SCROLL_FLAG_EXIT_UNTIL_COLLAPSED)) {
//                    // If the view is set only exit until it is collapsed, we'll abide by that
//                    snapBottom += ViewCompat.getMinimumHeight(offsetChild);
//                } else if (checkFlag(
//                        flags, AppBarLayout.LayoutParams.FLAG_QUICK_RETURN | AppBarLayout.LayoutParams.SCROLL_FLAG_ENTER_ALWAYS)) {
//                    // If it's set to always enter collapsed, it actually has two states. We
//                    // select the state and then snap within the state
//                    final int seam = snapBottom + ViewCompat.getMinimumHeight(offsetChild);
//                    if (offset < seam) {
//                        snapTop = seam;
//                    } else {
//                        snapBottom = seam;
//                    }
//                }
//
//                if (checkFlag(flags, AppBarLayout.LayoutParams.SCROLL_FLAG_SNAP_MARGINS)) {
//                    // Update snap destinations to include margins
//                    snapTop += lp.topMargin;
//                    snapBottom -= lp.bottomMargin;
//                }
//
//                final int newOffset = offset < (snapBottom + snapTop) / 2 ? snapBottom : snapTop;
//                animateOffsetTo(
//                        coordinatorLayout, abl, MathUtils.clamp(newOffset, -abl.getTotalScrollRange(), 0), 0);
//            }
//        }
//    }



}
