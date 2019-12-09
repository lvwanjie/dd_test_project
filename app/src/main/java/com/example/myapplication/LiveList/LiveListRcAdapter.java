package com.example.myapplication.LiveList;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.RoundedCorners;
import com.bumptech.glide.request.RequestOptions;
import com.example.myapplication.R;


import java.util.List;

public class LiveListRcAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private static final int ITEM_NORMAL = 0;
    private static final int ITEM_FOOT = 1;
    //加载状态
    private static final int FREE = 0;
    private static final int LOADING = 1;
    private int loadState = FREE;
    private boolean hasNextPage;
    private OnLoadListener mLoadListener;
    private OnItemClickListener mOnItemClickListener;
    private Context mContext;
    private List<LiveListItemEntity> mList;
    private RequestOptions ConnerOptions;
    public LiveListRcAdapter(Context context){
        this.mContext = context;
        ConnerOptions = RequestOptions.bitmapTransform(new RoundedCorners(6));
    }

    public void setData(List<LiveListItemEntity> list){
        this.mList = list;
        if(this.mList != null){
            notifyDataSetChanged();
        }
    }

    public void setOnLoadListener(OnLoadListener onLoadListener){
        this.mLoadListener = onLoadListener;
    }

    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.mOnItemClickListener = onItemClickListener;
    }

    public void loadComplete(){
        this.loadState = FREE;
    }

    public void setHasNextPage(boolean hasNextPage){
        this.hasNextPage = hasNextPage;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        RecyclerView.ViewHolder holder;
        if(viewType == ITEM_FOOT){
            View view = LayoutInflater.from(mContext).inflate(R.layout.simp_rc_item,parent,false);
            holder = new FootHolder(view);
        }else {
            View view = LayoutInflater.from(mContext).inflate(R.layout.item_live_list,parent,false);
            holder = new LiveListHolder(view);
        }
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        if(position == getItemCount() -1){
            //显示出footView
            FootHolder footHolder = (FootHolder) holder;
            if(!hasNextPage){
                //todo
                footHolder.itemView.setVisibility(View.GONE);
            } else {
                if (loadState == FREE) {
                    loadState = LOADING;
                    if (mLoadListener != null) {
                        mLoadListener.onLoad();
                    }
                }
                footHolder.itemView.setVisibility(View.VISIBLE);
            }
        }else {
            final LiveListItemEntity entity = mList.get(position);
            LiveListHolder liveListHolder = (LiveListHolder) holder;
            liveListHolder.tvLiveTitle.setText(entity.liveTitle);
            liveListHolder.tvAnchorName.setText(entity.anchorName);
            liveListHolder.tvLiveState.setText(entity.getLiveStateStr());
            if(entity.liveState == 3){
                liveListHolder.tvSpectatorNum.setVisibility(View.GONE);
            }else {
                liveListHolder.tvSpectatorNum.setVisibility(View.VISIBLE);
                liveListHolder.tvSpectatorNum.setText(entity.spectatorNum+"观看");
            }
            Glide.with(mContext).load(entity.anchorImgUrl).into(liveListHolder.ivAnchorImg);
            Glide.with(mContext).load(liveListHolder.imgBackground)
                    .into(liveListHolder.imgBackground);
            liveListHolder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(mOnItemClickListener != null){
                        mOnItemClickListener.onItemClick(entity);
                    }
                }
            });
        }
    }

    @Override
    public int getItemCount() {
        if(mList!=null){
           return mList.size()+1;
        }
        return 0;
    }

    @Override
    public int getItemViewType(int position) {
        if(position == getItemCount()-1){
            return ITEM_FOOT;
        }else {
            return ITEM_NORMAL;
        }
    }

    public interface OnItemClickListener{
        void onItemClick(LiveListItemEntity entity);
    }

    public interface OnLoadListener{
         void onLoad();
    }

    public static class LiveListHolder extends RecyclerView.ViewHolder{
        //直播标题
        public TextView tvLiveTitle;
        //主播头像
        public ImageView ivAnchorImg;
        //主播名称
        public TextView tvAnchorName;
        //直播状态
        public TextView tvLiveState;
        //观众人数
        public TextView tvSpectatorNum;
        //背景图
        public ImageView imgBackground;

        public LiveListHolder(@NonNull View itemView) {
            super(itemView);
            tvLiveTitle = itemView.findViewById(R.id.tv_live_title);
            ivAnchorImg = itemView.findViewById(R.id.iv_anchor);
            tvAnchorName = itemView.findViewById(R.id.tv_anchor);
            tvLiveState = itemView.findViewById(R.id.tv_live_state);
            tvSpectatorNum = itemView.findViewById(R.id.tv_spectator_num);
            imgBackground = itemView.findViewById(R.id.img_background);
        }

    }

    public static class FootHolder extends RecyclerView.ViewHolder{
        public FootHolder(@NonNull View itemView) {
            super(itemView);
        }
    }

}
