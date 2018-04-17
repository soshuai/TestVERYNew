package com.example.veryw.testveryssssss;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.example.veryw.testveryssssss.base.BaseActivity;
import com.scwang.smartrefresh.layout.api.RefreshLayout;

/**
 * 微博列表
 */
public class FeedlistPracticeActivity extends BaseActivity {

    private  boolean isFirstEnter = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_practice_feedlist);
        final RefreshLayout refreshLayout = (RefreshLayout) findViewById(R.id.refreshLayout);
        if (isFirstEnter) {
            refreshLayout.autoRefresh();
            isFirstEnter = false;
        }

    }

}
