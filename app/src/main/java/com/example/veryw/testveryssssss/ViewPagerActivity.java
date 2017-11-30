package com.example.veryw.testveryssssss;

import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.util.Log;

import com.example.veryw.testveryssssss.adapter.ExamplePagerAdapter;
import com.example.veryw.testveryssssss.base.BaseActivity;

import java.util.Arrays;
import java.util.List;

public class ViewPagerActivity extends BaseActivity {

    private ViewPager viewpager;
    private static final String[] CHANNELS = new String[]{"CUPCAKE", "DONUT", "ECLAIR", "GINGERBREAD", "HONEYCOMB", "ICE_CREAM_SANDWICH", "JELLY_BEAN", "KITKAT", "LOLLIPOP", "M", "NOUGAT"};
    private List<String> mDataList = Arrays.asList(CHANNELS);
    private ExamplePagerAdapter mExamplePagerAdapter = new ExamplePagerAdapter(mDataList);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_pager);
        initView();
    }

    private void initView() {
        viewpager = (ViewPager) findViewById(R.id.viewpager);
        viewpager.setAdapter(mExamplePagerAdapter);
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i("ssss","onDestroy");
    }
}
