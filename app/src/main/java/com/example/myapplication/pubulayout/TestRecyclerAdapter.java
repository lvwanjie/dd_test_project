package com.example.myapplication.pubulayout;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.R;

import java.util.ArrayList;
import java.util.List;

import static androidx.constraintlayout.widget.Constraints.TAG;

public class TestRecyclerAdapter extends RecyclerView.Adapter<TestRecyclerAdapter.MyHolder> {

    private Context context;
    private List<TestRecyclerItemEntity> list;
    public TestRecyclerAdapter(Context context){
        this.context = context;
        this.list = getFakeData();
    }

    public void setData(List list){
        this.list = list;
    }

    public void remove(int position){
        list.remove(position);
        notifyItemRemoved(position);
    }

    @NonNull
    @Override
    public MyHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(this.context).inflate(R.layout.test_recycler_item,parent,false);
        return new MyHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final MyHolder holder, final int position) {
        holder.textView.setText(list.get(position).str);
        holder.textView.measure(0,0);
        Log.i(TAG, "onBindViewHolder: text_view_height = "+holder.textView.getMeasuredHeight() +";position="+position);
        Log.i(TAG, "onBindViewHolder: text_view_Line = "+holder.textView.getLineCount() +";position="+position);
        if(holder.textView.getLineCount() >5){
            holder.button.setVisibility(View.VISIBLE);
            holder.button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(list.get(position).isOpen){
                        holder.textView.setMaxLines(5);
                    }else {
                        holder.textView.setMaxLines(Integer.MAX_VALUE);

                    }
                    list.get(position).isOpen = !list.get(position).isOpen;
                }
            });
        }else {
            holder.button.setVisibility(View.VISIBLE);
        }
        holder.textView.post(new Runnable() {
            @Override
            public void run() {
//                if(holder.textView.getLineCount() >5){
//                    holder.button.setVisibility(View.VISIBLE);
//                    holder.button.setOnClickListener(new View.OnClickListener() {
//                        @Override
//                        public void onClick(View v) {
//                            if(list.get(position).isOpen){
//                                holder.textView.setMaxLines(5);
//                            }else {
//                                holder.textView.setMaxLines(Integer.MAX_VALUE);
//
//                            }
//                            list.get(position).isOpen = !list.get(position).isOpen;
//                        }
//                    });
//                }else {
//                    holder.button.setVisibility(View.VISIBLE);
//                }
            }
        });
    }

    @Override
    public void onViewRecycled(@NonNull MyHolder holder) {
        super.onViewRecycled(holder);
        holder.unBind();
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public static class MyHolder extends RecyclerView.ViewHolder{

        public TextView textView;
        public Button button;
        public boolean isOPen= false;
        public MyHolder(@NonNull View itemView) {
            super(itemView);
            textView = itemView.findViewById(R.id.tv_text);
            button = itemView.findViewById(R.id.button);
        }

        public void unBind(){
            Log.i(TAG, "unBind: ");
        }


    }

    public static List getFakeData(){

        return getFakeData(10);
    }

    public static List getFakeData(int num){
        List list = new ArrayList();
        for(int i=0;i<num;i++){
            TestRecyclerItemEntity entity = new TestRecyclerItemEntity();
            if(i == 5){
                entity.str = "这是第"+i+"个大量文字大量文字大量文字大量文字大量文字大量文字大量文字大量文字大量文字大量文字大量文字大量文字大量文字大量文字大量文字大量文字大量文字大量文字大量文字大量文字大量文字大量文字大量文字大量文字大量文字大量文字大量文字大量文字大量文字大量文字大量文字大量文字大量文字大量文字大量文字大量文字大量文字大量文字大量文字大量文字大量文字大量文字大量文字大量文字大量文字大量文字大量文字大量文字大量文字大量文字大量文字大量文字大量文字大量文字大量文字大量文字大量文字大量文字大量文字大量文字大量文字大量文字大量文字大量文字";

            }else {
                entity.str = "这是第"+i+"个文案文案文案文案";
            }
            list.add(entity);
        }
        return list;
    }


}
