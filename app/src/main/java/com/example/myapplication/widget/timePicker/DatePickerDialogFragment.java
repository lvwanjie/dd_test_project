package com.example.myapplication.widget.timePicker;

import android.view.View;
import android.widget.DatePicker;
import android.widget.TextView;
import com.example.myapplication.R;
import com.example.myapplication.windows.BaseDialogFragment;

public class DatePickerDialogFragment extends BaseDialogFragment {

    private TextView tvCancel;
    private TextView tvSubmit;
    private DatePicker datePicker;
    private OnSubmitClickListener onSubmitClickListener;

    @Override
    protected int getLayoutID() {
        return R.layout.date_picker_dialog_content;
    }

    @Override
    protected void init() {
        tvCancel = mView.findViewById(R.id.tv_cancel);
        tvSubmit = mView.findViewById(R.id.tv_submit);
        datePicker = mView.findViewById(R.id.date_picker);
        tvSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(onSubmitClickListener != null){
                    onSubmitClickListener.onSubmitClick(datePicker.getYear(),datePicker.getMonth(),datePicker.getDayOfMonth());
                }
            }
        });

        tvCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dismiss();
            }
        });
    }

    public void setOnSubmitClickListener(OnSubmitClickListener onSubmitClickListener){
        this.onSubmitClickListener = onSubmitClickListener;
    }

    interface OnSubmitClickListener{

        void onSubmitClick(int y,int m,int d);
    }

}
