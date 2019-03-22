package com.padcmyanmar.padc7.mmnews.views.holders;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.padcmyanmar.padc7.mmnews.R;
import com.padcmyanmar.padc7.mmnews.data.vos.NewsVO;
import com.padcmyanmar.padc7.mmnews.delegates.NewsItemDelegate;

public class NewsViewHolder extends BaseNewsViewHolder {

    private NewsItemDelegate mDelegate;

    public NewsViewHolder(@NonNull View itemView, @NonNull NewsItemDelegate newsItemDelegate) {
        super(itemView);
        mDelegate = newsItemDelegate;
        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mDelegate.onTapNewsItem();
            }
        });
    }

    @Override
    public void bindData(NewsVO newsVO) {
        TextView tvNewsBrief = itemView.findViewById(R.id.tv_brief_news);
        tvNewsBrief.setText(newsVO.getBrief());
        ImageView ivNewsHeroImage = itemView.findViewById(R.id.iv_news_hero_image);

        Glide.with(itemView)
                .load(newsVO.getHeroImages())
                .into(ivNewsHeroImage);

    }

}
