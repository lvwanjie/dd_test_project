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
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.fragment.app.DialogFragment;

import com.example.myapplication.MyUtils;
import com.example.myapplication.R;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.bottomsheet.BottomSheetDialog;

import static android.content.Context.INPUT_METHOD_SERVICE;

public class MyDialogFragment1 extends DialogFragment {

    private EditText editText;
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
         editText = view.findViewById(R.id.edit);
         editText.requestFocus();
         showInput();
//         editText.post(new Runnable() {
//             @Override
//             public void run() {
//                 showInput();
//             }
//         });

        view.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,MyUtils.dp2Px(getContext(),500)));
        return view;
    }

    @Override
    public void onResume() {
        super.onResume();
        editText.requestFocus();
        editText.post(new Runnable() {
            @Override
            public void run() {
            }
        });


    }

    @Override
    public void onStart() {
        super.onStart();
            BottomSheetDialog   mBottomSheetDialog = (BottomSheetDialog) getDialog();
          View  bottomSheet =
                    mBottomSheetDialog.getDelegate().findViewById(com.google.android.material.R.id.design_bottom_sheet);
            if (bottomSheet != null) {
                BottomSheetBehavior  behavior = BottomSheetBehavior.from(bottomSheet);
                /** 跳过半折叠状态,防止下拉会出现半折叠情况 */
                behavior.setSkipCollapsed(true);
                /** 改变collapsed的值，实现下拉未超过一半自动回弹的效果*/
//                behavior.setPeekHeight(0);
                behavior.setState(BottomSheetBehavior.STATE_EXPANDED);
            }

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
        BottomSheetDialog bottomSheetDialog = new BottomSheetDialog(getContext());

        return bottomSheetDialog;
    }

    private void showInput(){
        InputMethodManager imm = null;
            imm = (InputMethodManager) getActivity().getSystemService(INPUT_METHOD_SERVICE);

        imm.showSoftInput(editText, InputMethodManager.SHOW_IMPLICIT);


    }
}
