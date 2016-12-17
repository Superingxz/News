package com.jeason.news.test;

import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.ViewGroup;
import android.widget.ListView;

import com.jeason.news.R;
import com.jeason.news.simple.BannerPagerAdapter;
import com.jsonmo.xrefreshview.PullToRefreshListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private PullToRefreshListView pulltorefresh;
    private ViewPager viewPager;
    private BannerPagerAdapter bannerPagerAdapter;
    private SportsAdapger sportsAdapger;
    private List<bean> beanList = new ArrayList<>();
    private ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        loadData();
    }

    private void initView() {
        viewPager = (ViewPager) findViewById(R.id.viewpager);
        ViewGroup.LayoutParams vLp = viewPager.getLayoutParams();
        vLp.height = vLp.width / 2;
        viewPager.setLayoutParams(vLp);
        pulltorefresh = (PullToRefreshListView) findViewById(R.id.listview);
        listView = pulltorefresh.getRefreshableView();


    }

    private void loadData() {
        bannerPagerAdapter = new BannerPagerAdapter(this, appConfig.ImageUrls);
        viewPager.setAdapter(bannerPagerAdapter);

        listView.addHeaderView(viewPager);

        beanList = getBeanList();
        sportsAdapger = new SportsAdapger(this,beanList);
        listView.setAdapter(sportsAdapger);

    }

    public List<bean> getBeanList() {
        List<bean> beanList = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            beanList.add(new bean("title1--" + i, "title2--" + i));
        }
        return beanList;
    }
}
