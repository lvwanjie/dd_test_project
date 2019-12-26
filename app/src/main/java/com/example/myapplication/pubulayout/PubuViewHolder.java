package com.example.myapplication.pubulayout;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import com.bumptech.glide.Glide;
import com.example.myapplication.R;

public class PubuViewHolder extends RecyclerView.ViewHolder {

    public ImageView imageView;
    public TextView textView;
    public Context context;

    public PubuViewHolder(@NonNull View itemView) {
        super(itemView);
        context = itemView.getContext();
        imageView = itemView.findViewById(R.id.img);
        textView = itemView.findViewById(R.id.text_view);
    }

    public void setData(PubuItemEntity entity,int type){
        if(type ==1 ){
            imageView.getLayoutParams().height = 853;

        }else if(type == 0){
            imageView.getLayoutParams().height = 480;

        }else  if(type == 4){
            imageView.getLayoutParams().height = 100;
        } else {
            imageView.getLayoutParams().height = 200;
        }
        Glide.with(context).load(entity.imgUrl).into(imageView);
        textView.setText(entity.text);
    }
}
