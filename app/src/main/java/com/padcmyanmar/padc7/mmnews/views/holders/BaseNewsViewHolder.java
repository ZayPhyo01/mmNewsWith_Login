package com.padcmyanmar.padc7.mmnews.views.holders;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.padcmyanmar.padc7.mmnews.data.vos.NewsVO;

public abstract class BaseNewsViewHolder extends BaseViewHolder<NewsVO> {

    public BaseNewsViewHolder(@NonNull View itemView) {
        super(itemView);
    }

}
