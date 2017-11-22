package com.example.veryw.testveryssssss;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.LinearLayout;
import com.example.veryw.testveryssssss.adapter.MyAdapter;
import com.example.veryw.testveryssssss.base.BaseActivity;


public class MainActivity extends BaseActivity implements MyAdapter.RecyclerviewOnItemClickListenr {

    private RecyclerView rv;

    private LinearLayout linerlayout;
    private String[] strings;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();

    }

    private void initView() {
        rv = (RecyclerView) findViewById(R.id.rv);
        linerlayout = (LinearLayout) findViewById(R.id.linerlayout);
        linerlayout.getBackground().mutate().setAlpha(100);
        rv.setLayoutManager(new LinearLayoutManager(this));//创建默认的线性LayoutManager
        rv.setHasFixedSize(true);//如果可以确定每个item的高度是固定的，设置这个选项可以提高性能

        rv.setAdapter(new MyAdapter(getDataList(), this));
    }

    public String[] getDataList() {
        strings = new String[11];
        for (int i = 0; i < strings.length; i++) {
            strings[i] = "我的第" + (i + 1) + "个Demo";
        }
        strings[0] = "温水煮青蛙";
        strings[1] = "Rotate旋转动画";
        return strings;
    }

    @Override
    public void onclickHaha(View view, int position) {
        switch (position) {
            case 1:
                startActivity(new Intent(this,RotateActivity.class));
                break;

            default:
                break;
        }
        androidToast("点击了" + strings[position]);
    }
}
