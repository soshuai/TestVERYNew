package com.example.veryw.testveryssssss;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;

import com.example.veryw.testveryssssss.adapter.ExamplePagerAdapter;
import com.example.veryw.testveryssssss.base.BaseActivity;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ViewPagerActivity extends BaseActivity {

    private ViewPager viewpager;
    private static final String[] CHANNELS = new String[]{"首页", "关注", "环球", "文史"};
    private List<String> mDataList = Arrays.asList(CHANNELS);
    private List<String> dataList = new ArrayList<>();
    private ExamplePagerAdapter mExamplePagerAdapter = new ExamplePagerAdapter(mDataList);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_pager);
        initView();
    }

    @Override
    public void onSaveInstanceState(Bundle outState, PersistableBundle outPersistentState) {
        super.onSaveInstanceState(outState, outPersistentState);
    }

    @Override
    public void onRestoreInstanceState(Bundle savedInstanceState, PersistableBundle persistentState) {
        super.onRestoreInstanceState(savedInstanceState, persistentState);
    }

    private void initView() {
        dataList.add("首页");
        dataList.add("关注");
        dataList.add("环球");
        dataList.add("文史");
        viewpager = (ViewPager) findViewById(R.id.viewpager);
        final ExamplePagerAdapter pagerAdapter = new ExamplePagerAdapter(dataList);
        viewpager.setAdapter(pagerAdapter);
        findViewById(R.id.button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dataList.remove(0);
                pagerAdapter.notifyDataSetChanged();
            }
        });
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i("ssss","onDestroy");
    }

    class MyPagerAdapter extends FragmentPagerAdapter{
        FragmentManager mFragmentManager;
        FragmentTransaction mCurTransaction;
        List<Fragment> fragments;
        public MyPagerAdapter(FragmentManager fm) {
            super(fm);
            mFragmentManager=fm;
        }

        @Override
        public Fragment getItem(int position) {
            return null;
        }

        @Override
        public int getCount() {
            return 0;
        }

        @Override
        public int getItemPosition(Object object) {
            return POSITION_NONE;
        }



//        @Override
//        public long getItemId(int position) {
//            return fragments.get(position).hashCode();
//        }
    }
}
