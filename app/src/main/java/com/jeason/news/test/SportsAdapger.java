package com.jeason.news.test;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.jeason.news.R;

import java.util.List;

/**
 * Created by Administrator on 2016/12/17.
 */

public class SportsAdapger extends BaseAdapter {
    private Context context;
    private List<sport> sportlist;
    private List<bean> beanList;
    private LayoutInflater inflater;

    public SportsAdapger(Context context, List<bean> beanList) {
        this.context = context;
        this.beanList = beanList;
        this.inflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return beanList.size();
    }

    @Override
    public Object getItem(int position) {
        return beanList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public int getItemViewType(int position) {

        return super.getItemViewType(position);
    }

    @Override
    public int getViewTypeCount() {
        return 1;
    }

    @Override
    public View getView(int position, View converView, ViewGroup parent) {
        beanViewHolder beanViewHolder ;
        if (converView == null) {
            beanViewHolder = new beanViewHolder();
            converView = inflater.inflate(R.layout.layout_item, parent, false);
            beanViewHolder.title1 = (TextView) converView.findViewById(R.id.title1);
            beanViewHolder.titel2 = (TextView) converView.findViewById(R.id.title2);

            converView.setTag(beanViewHolder);
        } else {
            beanViewHolder = (beanViewHolder) converView.getTag();
            if (beanList != null && beanList.size() > 0) {
                beanViewHolder.title1.setText(beanList.get(position).getTitle1());
                beanViewHolder.titel2.setText(beanList.get(position).getTitel2());
            }
        }
        return converView;
    }

    class beanViewHolder{
        TextView title1,titel2;
    }
}
