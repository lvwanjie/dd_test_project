package com.example.myapplication.windows;

import android.content.Context;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;

import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.FragmentManager;

import com.example.myapplication.R;


/**
 * Author : xuan.
 * Date : 2019/3/26.
 * Description :全屏的DialogFragment
 */
public abstract class BaseFullScreenDialogFragment extends DialogFragment {
    protected Context mContext;
    protected View mView;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        mContext = context;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

            setStyle(STYLE_NO_FRAME, android.R.style.Theme_Holo_Light);

        if (!getShowsDialog()) {
            dismiss();
            return;
        }
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        getDialog().requestWindowFeature(Window.FEATURE_NO_TITLE);
        mView = inflater.inflate(getLayoutID(), container);
        getDialog().setCanceledOnTouchOutside(true);
        Window win = getDialog().getWindow();
        win.setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
        if (getDialog().getWindow() != null)
            win.setBackgroundDrawable(ContextCompat.getDrawable(mContext, android.R.color
                    .transparent));
        DisplayMetrics dm = new DisplayMetrics();
        if (getActivity() != null) {
            getActivity().getWindowManager().getDefaultDisplay().getMetrics(dm);
        }
        WindowManager.LayoutParams params = win.getAttributes();
        //设置弹窗大小为会屏
        params.width = ViewGroup.LayoutParams.MATCH_PARENT;
        params.height = ViewGroup.LayoutParams.MATCH_PARENT;
        params.dimAmount = 0.0f;
        params.flags |= WindowManager.LayoutParams.FLAG_DIM_BEHIND;
        win.setAttributes(params);
        init();
        return mView;
    }

    protected abstract int getLayoutID();

    protected abstract void init();

    /**
     * 状态栏颜色
     */
    protected int statusBarColor() {
        return Color.WHITE;
    }


    @Override
    public void show(FragmentManager manager, String tag) {
        try {
            super.show(manager, tag);
        } catch (Exception e) {
        }
    }

    @Override
    public void onDestroyView() {
        setShowsDialog(false);
        super.onDestroyView();
    }
}
