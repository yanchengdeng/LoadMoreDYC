package com.yllt.cxlife.viewholdes;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.yllt.cxlife.R;

import de.hdodenhof.circleimageview.CircleImageView;

/**
 * Created by yanchengdeng  on 2016/4/7.
 * 类表显示 item
 */
public class ChessesItemViewHolder extends RecyclerView.ViewHolder {
    public CircleImageView imageView;

    public TextView tvTittle;

    public ChessesItemViewHolder(View itemView) {
        super(itemView);
        imageView = (CircleImageView) itemView.findViewById(R.id.avatar);
        tvTittle = (TextView) itemView.findViewById(R.id.tv_tittle);
    }
}
