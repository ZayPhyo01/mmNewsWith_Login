package com.padcmyanmar.padc7.mmnews.views.holders;

import android.support.annotation.NonNull;
import android.view.View;
import android.widget.TextView;

import com.padcmyanmar.padc7.mmnews.R;
import com.padcmyanmar.padc7.mmnews.data.vos.NewsVO;

public class NewsSmallViewHolder extends BaseNewsViewHolder {

    public NewsSmallViewHolder(@NonNull View itemView) {
        super(itemView);
    }

    @Override
    public void bindData(NewsVO newsVO) {
        TextView tvNewsBrief = itemView.findViewById(R.id.tv_brief_news);
        tvNewsBrief.setText(newsVO.getBrief());
    }
}
