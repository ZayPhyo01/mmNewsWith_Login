package com.padcmyanmar.padc7.mmnews.views.holders;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;

public abstract class BaseViewHolder<T> extends RecyclerView.ViewHolder implements View.OnClickListener {

    public BaseViewHolder(@NonNull View itemView) {
        super(itemView);

        itemView.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

    }

    public abstract void bindData(T t);
}
