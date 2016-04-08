package com.yllt.cxlife.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.yllt.cxlife.R;
import com.yllt.cxlife.beans.LastActivity;

/**
 * Created by Administrator on 2016/4/6.
 */
public class LastestActivityAdapter extends BaseArrayAdapter<LastActivity> {
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        return  LayoutInflater.from(parent.getContext()).inflate(R.layout.adapter_lastest_activity, parent, false);
    }
}
