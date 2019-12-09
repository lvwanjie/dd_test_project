//package com.example.myapplication.LiveList;
//
//import android.content.Context;
//import android.view.LayoutInflater;
//import android.view.View;
//import android.view.ViewGroup;
//import android.widget.ImageView;
//import android.widget.TextView;
//
//import androidx.annotation.NonNull;
//import androidx.recyclerview.widget.RecyclerView;
//
//import com.bumptech.glide.Glide;
//import com.bumptech.glide.load.resource.bitmap.RoundedCorners;
//import com.bumptech.glide.request.RequestOptions;
//import com.dangdang.buy2.widget.RoundedImageView;
//import com.dangdang.live.R;
//
//import java.util.List;
//
//public class LiveListRcAdapterCopy extends RecyclerView.Adapter<LiveListRcAdapter.LiveListHolder> {
//
//    private Context mContext;
//    private List<LiveListItemEntity> mList;
//    private RequestOptions ConnerOptions;
//    public LiveListRcAdapterCopy(Context context){
//        this.mContext = context;
//        ConnerOptions = RequestOptions.bitmapTransform(new RoundedCorners(6));
//    }
//
//    public void setData(List<LiveListItemEntity> list){
//        this.mList = list;
//        if(this.mList != null){
//            notifyDataSetChanged();
//        }
//    }
//
//    @NonNull
//    @Override
//    public LiveListRcAdapter.LiveListHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
//        View view = LayoutInflater.from(mContext).inflate(R.layout.item_live_list,parent,false);
//        LiveListHolder holder = new LiveListHolder(view);
//        return holder;
//    }
//
//    @Override
//    public void onBindViewHolder(@NonNull LiveListRcAdapter.LiveListHolder holder, int position) {
//        LiveListItemEntity entity = mList.get(position);
//        holder.tvLiveTitle.setText(entity.liveTitle);
//        holder.tvAnchorName.setText(entity.anchorName);
//        holder.tvLiveState.setText(entity.liveState+"");
//        holder.tvSpectatorNum.setText(entity.spectatorNum+"观看");
//        Glide.with(mContext).load(entity.anchorImgUrl).
//                apply(RequestOptions.circleCropTransform()).into(holder.ivAnchorImg);
//        Glide.with(mContext).load("https://b-ssl.duitang.com/uploads/item/201208/30/20120830173930_PBfJE.jpeg")
//                .into(holder.imgBackground);
//
//    }
//
//    @Override
//    public int getItemCount() {
//        if(mList!=null){
//           return mList.size();
//        }
//        return 0;
//    }
//
//    public static class LiveListHolder extends RecyclerView.ViewHolder{
//        //直播标题
//        public TextView tvLiveTitle;
//        //主播头像
//        public ImageView ivAnchorImg;
//        //主播名称
//        public TextView tvAnchorName;
//        //直播状态
//        public TextView tvLiveState;
//        //观众人数
//        public TextView tvSpectatorNum;
//        //背景图
//        public RoundedImageView imgBackground;
//
//        public LiveListHolder(@NonNull View itemView) {
//            super(itemView);
//            tvLiveTitle = itemView.findViewById(R.id.tv_live_title);
//            ivAnchorImg = itemView.findViewById(R.id.iv_anchor);
//            tvAnchorName = itemView.findViewById(R.id.tv_anchor);
//            tvLiveState = itemView.findViewById(R.id.tv_live_state);
//            tvSpectatorNum = itemView.findViewById(R.id.tv_spectator_num);
//            imgBackground = itemView.findViewById(R.id.img_background);
//
//        }
//    }
//
//
//}
