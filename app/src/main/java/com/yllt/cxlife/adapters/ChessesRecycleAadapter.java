package com.yllt.cxlife.adapters;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bumptech.glide.Glide;
import com.yllt.cxlife.R;
import com.yllt.cxlife.beans.Cheeses;
import com.yllt.cxlife.beans.LastActivity;
import com.yllt.cxlife.liseners.OnLoadMoreListener;
import com.yllt.cxlife.viewholdes.ChessesItemViewHolder;
import com.yllt.cxlife.viewholdes.LoadMoreViewHolder;

import java.util.List;
import java.util.Random;

/**
 * Created by Administrator on 2016/4/7.
 */
public class ChessesRecycleAadapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private final int VIEW_TYPE_ITEM = 0;
    private final int VIEW_TYPE_LOADING = 1;
    private OnLoadMoreListener mOnLoadMoreListener;
    private boolean isLoading;
    private int visibleThreshold = 5;
    private int lastVisibleItem, totalItemCount;
    private List<LastActivity> activities;
    private RecyclerView mRecyclerView;

    public ChessesRecycleAadapter(List<LastActivity> cheeses, RecyclerView recycleView) {
        this.activities = cheeses;
        this.mRecyclerView = recycleView;
        final LinearLayoutManager linearLayoutManager = (LinearLayoutManager) mRecyclerView.getLayoutManager();
        mRecyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);

                totalItemCount = linearLayoutManager.getItemCount();
                lastVisibleItem = linearLayoutManager.findLastVisibleItemPosition();

                if (!isLoading && totalItemCount <= (lastVisibleItem + visibleThreshold)) {
                    if (mOnLoadMoreListener != null) {
                        mOnLoadMoreListener.onLoadMore();
                    }
                    isLoading = true;
                }
            }
        });
    }


    public void setOnLoadMoreListener(OnLoadMoreListener mOnLoadMoreListener) {
        this.mOnLoadMoreListener = mOnLoadMoreListener;
    }

    @Override
    public int getItemViewType(int position) {
        return activities.get(position) == null ? VIEW_TYPE_LOADING : VIEW_TYPE_ITEM;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (viewType == VIEW_TYPE_ITEM) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item, parent, false);
            return new ChessesItemViewHolder(view);
        } else if (viewType == VIEW_TYPE_LOADING) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_loader_footer, parent, false);
            return new LoadMoreViewHolder(view);
        }
        return null;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        if (holder instanceof ChessesItemViewHolder) {
            LastActivity item = activities.get(position);
            ChessesItemViewHolder chessesItemViewHolder = (ChessesItemViewHolder) holder;
            Glide.with(chessesItemViewHolder.imageView.getContext())
                    .load(item.getDrawable())
                    .fitCenter()
                    .into(chessesItemViewHolder.imageView);

            if (!TextUtils.isEmpty(item.getTittle())) {
                chessesItemViewHolder.tvTittle.setText(item.getTittle());
            }

        } else if (holder instanceof LoadMoreViewHolder) {
            LoadMoreViewHolder loadMoreViewHolder = (LoadMoreViewHolder) holder;
            loadMoreViewHolder.progressBar.setIndeterminate(true);
        }

    }

    @Override
    public int getItemCount() {
        return activities.size();
    }

    public void setLoaded() {
        isLoading = false;
    }
}
