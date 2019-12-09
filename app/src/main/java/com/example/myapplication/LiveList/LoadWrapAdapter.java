package com.example.myapplication.LiveList;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.R;


public abstract class LoadWrapAdapter extends RecyclerView.Adapter {

    private RecyclerView.Adapter innerAdapter;
    private Context context;
    private static final int ITEM_NORMAL = 0;
    private static final int ITEM_FOOT = 1;

    public LoadWrapAdapter(Context context, RecyclerView.Adapter adapter){
        this.innerAdapter = adapter;
        this.context = context;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        if(viewType == ITEM_FOOT){
            View view = LayoutInflater.from(context).inflate(R.layout.simp_rc_item,parent,false);
            return new FootHolder(view);
        }else {
           return onCreateViewHolder1(parent,viewType);
        }

    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        if(position == getItemCount() -1){

        }else {
            onBindViewHolder1(holder,position);
        }
    }

    @Override
    public int getItemCount() {
        if(innerAdapter == null){
            return 0;
        }
        return getItemCount1()+1;
    }

    @Override
    public int getItemViewType(int position) {
        if(position == getItemCount()-1){
            return ITEM_FOOT;
        }
        return getItemViewType1(position);
    }

    public abstract int getItemViewType1(int position);

    public abstract int getItemCount1();

    public abstract void onBindViewHolder1(@NonNull RecyclerView.ViewHolder holder, int position);

    public abstract RecyclerView.ViewHolder onCreateViewHolder1(@NonNull ViewGroup parent, int viewType);

    public static class FootHolder extends RecyclerView.ViewHolder{

        public FootHolder(@NonNull View itemView) {
            super(itemView);
        }
    }
}
