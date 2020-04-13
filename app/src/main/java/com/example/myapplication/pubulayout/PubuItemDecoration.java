package com.example.myapplication.pubulayout;

import android.graphics.Rect;
import android.util.Log;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import com.example.myapplication.MyApplication;
import com.example.myapplication.MyUtils;

public class PubuItemDecoration extends RecyclerView.ItemDecoration {

    private String TAG ="PubuItemDecoration";

    @Override
    public void getItemOffsets(@NonNull Rect outRect, @NonNull View view, @NonNull RecyclerView parent, @NonNull RecyclerView.State state) {
        super.getItemOffsets(outRect, view, parent, state);

        StaggeredGridLayoutManager.LayoutParams params = (StaggeredGridLayoutManager.LayoutParams) view.getLayoutParams();
        Log.i(TAG, "getItemOffsets: spanIndex = " + params.getSpanIndex() );

        int spanIndex = params.getSpanIndex();
        if(spanIndex == 0){
            outRect.left = MyUtils.dp2Px(MyApplication.getInstance(),12);
            outRect.right = MyUtils.dp2Px(MyApplication.getInstance(),5);
        }else if(spanIndex == 1){
            outRect.left = MyUtils.dp2Px(MyApplication.getInstance(),5);
            outRect.right = MyUtils.dp2Px(MyApplication.getInstance(),12);
        }

        int adapterPosition = parent.getChildAdapterPosition(view);
        int layoutPosition = parent.getChildLayoutPosition(view);
        Log.i(TAG, "getItemOffsets: adapterPosition="+adapterPosition +"；layoutPosition="+layoutPosition);
    }
}
