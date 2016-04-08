package com.yllt.cxlife.fragments;

import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.yllt.cxlife.R;
import com.yllt.cxlife.adapters.ChessesRecycleAadapter;
import com.yllt.cxlife.beans.Cheeses;
import com.yllt.cxlife.beans.LastActivity;
import com.yllt.cxlife.liseners.OnLoadMoreListener;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

public class LastestActivityFragment extends Fragment {

    @Bind(R.id.no_data)
    TextView noData;
    @Bind(R.id.recycleView)
    RecyclerView recycleView;


    private ChessesRecycleAadapter chessesRecycleAadapter;

    private List<LastActivity> activities = new ArrayList<>();


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_lastest_activity, null);
        ButterKnife.bind(this, view);
        initView();
        addLisener();
        return view;
    }

    private void initView() {
        for (int i = 0; i < 30; i++) {
            activities.add(new LastActivity(Cheeses.getRandomCheeseDrawable(), (Cheeses.sCheeseStrings[(int) (30 * Math.random())]) + "..." + i));
        }
        recycleView.setLayoutManager(new LinearLayoutManager(getActivity()));
        chessesRecycleAadapter = new ChessesRecycleAadapter(activities, recycleView);
        recycleView.setAdapter(chessesRecycleAadapter);

    }

    private void getData(final int size) {
        activities.add(null);
        chessesRecycleAadapter.notifyItemInserted(activities.size() - 1);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                //Remove loading item
                activities.remove(activities.size() - 1);
                chessesRecycleAadapter.notifyItemRemoved(activities.size());
                for (int i = size; i < size + 20; i++) {
                    activities.add(new LastActivity(Cheeses.getRandomCheeseDrawable(), (Cheeses.sCheeseStrings[(int) (30 * Math.random())]) + "..." + i));
                }
                chessesRecycleAadapter.notifyDataSetChanged();
                chessesRecycleAadapter.setLoaded();
            }
        }, 3000);
    }

    private void addLisener() {


        chessesRecycleAadapter.setOnLoadMoreListener(new OnLoadMoreListener() {
            @Override
            public void onLoadMore() {

                getData(activities.size());

            }


        });


    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);
    }
}
