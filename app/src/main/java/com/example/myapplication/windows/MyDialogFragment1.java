package com.example.myapplication.windows;

import android.app.AlertDialog;
import android.app.Dialog;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;

import com.example.myapplication.MyUtils;
import com.example.myapplication.R;
import com.google.android.material.bottomsheet.BottomSheetDialog;

public class MyDialogFragment1 extends DialogFragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        Dialog dialog = getDialog();
        if (dialog != null) {
            dialog.requestWindowFeature(Window.FEATURE_OPTIONS_PANEL);
            Window window = dialog.getWindow();
            window.setGravity(Gravity.BOTTOM);
            if (window != null) {
                window.setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
//                int resId = getCustomWindowAnim();
//                if (resId > 0) {
//                    window.setWindowAnimations(resId);
//                }
            }
        }
        View view = inflater.inflate(R.layout.popup_window_layout, container);

        return view;
    }


//    @Override
//    protected int getLayoutID() {
//        return R.layout.popup_window_layout;
//    }

//    @Override
//    protected void init() {
////        Window win = getDialog().getWindow();
////        win.setLayout(ViewGroup.LayoutParams.MATCH_PARENT, MyUtils.dp2Px(getContext(),250));
//    }

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        return new BottomSheetDialog(getContext());
    }
}
