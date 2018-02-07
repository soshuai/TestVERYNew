package com.example.veryw.testveryssssss;

import android.os.Bundle;
import android.os.Handler;
import android.view.ViewConfiguration;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.veryw.testveryssssss.base.BaseActivity;
import com.example.veryw.testveryssssss.library.PullToRefreshBase;
import com.example.veryw.testveryssssss.library.PullToRefreshListView;
import com.example.veryw.testveryssssss.library.PullToRefreshBase.Mode;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;

public class PulltoRefreshActivity extends BaseActivity {

    private PullToRefreshListView listview;
    private List<String> list=new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pullto_refresh);
        initView();
    }

    private void initView() {
        listview = (PullToRefreshListView) findViewById(R.id.listview);
        listview.setMode(Mode.PULL_FROM_START);
        listview.setPullToRefreshOverScrollEnabled(false);
        listview.getRefreshableView().setFriction(ViewConfiguration.getScrollFriction() * 2);
        listview.setOnRefreshListener(new PullToRefreshBase.OnRefreshListener2<ListView>() {
            @Override
            public void onPullDownToRefresh(PullToRefreshBase<ListView> v) {
//                newData(false);下拉刷新

                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        listview.onRefreshComplete();
                    }
                },2000);
            }

            @Override
            public void onPullUpToRefresh(PullToRefreshBase<ListView> v) {
//                addData(false);上拉加载
            }
        });
        for (int i = 1; i < 60; i++) {
            list.add("第"+i+"条数据");
        }
        listview.setAdapter(new ArrayAdapter<String>(this,android.R.layout.simple_spinner_dropdown_item,list));

        listview.setSelfRefreshing();
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                listview.setSelfStop();
            }
        },2000);
    }
}
