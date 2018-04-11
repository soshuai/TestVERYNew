package com.example.veryw.testveryssssss;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import com.example.veryw.testveryssssss.base.BaseActivity;
import com.example.veryw.testveryssssss.view.RefreshableView;

import java.util.ArrayList;

public class GuolinListActivity extends BaseActivity {
    RefreshableView refreshableView;
    ListView listView;
    ArrayAdapter<String> adapter;
    String[] items = { "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L" };
    private ArrayList<String> dataList=new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_guolin_list);
        refreshableView = (RefreshableView) findViewById(R.id.refreshable_view);
        listView = (ListView) findViewById(R.id.list_view);
        for (int i = 0; i < 10; i++) {
            dataList.add("nima "+i);
        }
        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, dataList);
        listView.setAdapter(adapter);
//        refreshableView.setRefreshState();
        refreshableView.setOnRefreshListener(new RefreshableView.PullToRefreshListener() {
            @Override
            public void onRefresh() {
                try {
                    String[] items = { "长河落日圆", "B", "大漠孤烟直", "D", "长风破浪会有时", "F", "风萧萧兮易水寒", "H", "I", "J", "K", "L" };
                    dataList.clear();
                    for (int i = 0; i < items.length; i++) {
                        dataList.add(items[i]);
                    }
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                     e.printStackTrace();
                }
                refreshableView.finishRefreshing();
            }
        }, 0);
    }
}
