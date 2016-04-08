package com.yllt.cxlife.viewholdes;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ProgressBar;

import com.yllt.cxlife.R;

/**
 * Created by yanchengdeng on 2016/4/7.
 * 加载更多  RecyclerView.ViewHolder
 */
public class LoadMoreViewHolder extends RecyclerView.ViewHolder{
    public View loadMore;
    public ProgressBar progressBar;
    public LoadMoreViewHolder(View itemView) {
        super(itemView);
        loadMore = itemView.findViewById(R.id.load_more_progressBar);
        progressBar = (ProgressBar) itemView.findViewById(R.id.progress_bar_parent);
    }
}
