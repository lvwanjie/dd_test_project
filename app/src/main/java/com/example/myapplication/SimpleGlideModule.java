package com.example.myapplication;

import android.content.Context;

import androidx.annotation.NonNull;

import com.bumptech.glide.Glide;
import com.bumptech.glide.GlideBuilder;
import com.bumptech.glide.Registry;
import com.bumptech.glide.load.DecodeFormat;
import com.bumptech.glide.load.Option;
import com.bumptech.glide.load.resource.bitmap.Downsampler;
import com.bumptech.glide.module.GlideModule;
import com.bumptech.glide.request.RequestOptions;

public class SimpleGlideModule implements GlideModule {
    @Override
    public void applyOptions(Context context, GlideBuilder builder) {
        RequestOptions options=new RequestOptions()
                .placeholder(R.drawable.default_icon)
                .error(R.drawable.default_icon)
                .fallback(R.drawable.default_icon)
                .set(Downsampler.DECODE_FORMAT,DecodeFormat.PREFER_RGB_565)
                //.format(DecodeFormat.PREFER_RGB_565)
                .set(Option.memory("com.bumptech.glide.load.model.stream.HttpGlideUrlLoader.Timeout"),6000);//网络连接和读取数据的超时时间
        builder.setDefaultRequestOptions(options);
    }



    @Override
    public void registerComponents(@NonNull Context context, @NonNull Glide glide, @NonNull Registry registry) {

    }
}