package com.example.myapplication.livemessage;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.R;

import java.util.List;

public class LiveRecyAdapter extends RecyclerView.Adapter<LiveRecyAdapter.LiveRecyHolder> {

    private Context mContext;
    private List<String> mList;

    public LiveRecyAdapter(Context context, List<String> list){
        this.mContext = context;
        this.mList = list;
    }


    @NonNull
    @Override
    public LiveRecyHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.simp_rc_item,parent,false);
        LiveRecyHolder liveRecyHolder = new LiveRecyHolder(view);
        return liveRecyHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull LiveRecyHolder holder, int position) {
        String text = mList.get(position);
        holder.textView.setText(text);

    }

    @Override
    public int getItemCount() {
        if(this.mList!=null && this.mList.size()>0){
            return this.mList.size();
        }
        return 0;
    }

    public static class LiveRecyHolder extends RecyclerView.ViewHolder{

        public TextView textView;
        public LiveRecyHolder(@NonNull View itemView) {
            super(itemView);
            textView =  itemView.findViewById(R.id.text_view);
        }
    }
}
