package com.example.veryw.testveryssssss;

import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.veryw.testveryssssss.base.BaseActivity;
import com.example.veryw.testveryssssss.view.LineGridView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 动画
 * 自定view
 */
public class ViewsActivity extends BaseActivity implements View.OnClickListener {

    private LineGridView linegridview;
    private String[] chennel = new String[]{"红黄蓝", "一带一路", "自贸区", "两会", "足协会", "冬运会", "韩朝问题", "五五开", "UU 上位"};
    private List<String> keywordList = Arrays.asList(chennel);//缺点 keywordList里的元素不能增加
    private List<String> data = new ArrayList<>();
    private TextView tv1;
    private TextView tv2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_views);
        data.addAll(keywordList);
        //////保证 LineGridView 底部充满空白的格子，不会有空余
        int s = data.size() % 4;
        if (s != 0) {
            for (int i = 0; i < 4 - s; i++) {
                data.add("");
            }
        }
        ///////////////////////////

        initView();


//        animation.setAnimationListener(new Animation.AnimationListener() {
//            @Override
//            public void onAnimationStart(Animation animation) {
//            }
//
//            @Override
//            public void onAnimationEnd(Animation animation) {
//            }
//
//            @Override
//            public void onAnimationRepeat(Animation animation) {
//            }
//        });

    }

    private void initView() {
        tv1 = (TextView) findViewById(R.id.tv1);
        tv2 = (TextView) findViewById(R.id.tv2);
        tv2.setOnClickListener(this);
        linegridview = (LineGridView) findViewById(R.id.linegridview);
        linegridview.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, data));
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.tv2:
                Animation animation = AnimationUtils.loadAnimation(ViewsActivity.this, R.anim.together_anim);
                linegridview.startAnimation(animation);
                break;
            default:
                break;
        }
    }
}
