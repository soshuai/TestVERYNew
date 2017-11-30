package com.example.veryw.testveryssssss;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.veryw.testveryssssss.adapter.MyAdapter;
import com.example.veryw.testveryssssss.base.BaseActivity;

import butterknife.BindView;


public class MainActivity extends BaseActivity implements MyAdapter.RecyclerviewOnItemClickListenr {

    private RecyclerView rv;

    private LinearLayout linerlayout;
    private String[] strings;
//测试  测试   测试

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        /////////////////////
//        setSwipeBackEnable(false);//禁掉左滑退出testest


        initView();
//        m1(2);
//        m1((Integer) 10);

        Log.i("haiyangsb", "最终结果" + getNum());
    }

    /**
     * 先到catch 发现有return直接执行的finally
     *
     * @return
     */
    private int getNum() {
        try {
            int a = 1 / 0;
            Log.i("haiyangsb", "1");
            return 1;
        } catch (Exception e) {
            Log.i("haiyangsb", "2");
            return 2;
        } finally {
            Log.i("haiyangsb", "3");
            return 3;
        }
    }

//    private void m1(int i) {
//        androidToast(i + "");
//    }
//
//    private void m1(Integer i) {
//        androidToast(i + "");
//    }


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
        strings[2] = "3D画廊";
        strings[3] = "鹰击长空";
        strings[4] = "viewpager";
        return strings;
    }

    @Override
    public void onclickHaha(View view, int position) {
        switch (position) {
            case 1:
                Intent intent1 = new Intent(this, RotateActivity.class);
                startActivity(intent1);
                break;
            case 2:
                Intent intent2 = new Intent(this, GalleryActivity.class);
                startActivity(intent2);
                break;
            case 3:
                Intent intent3 = new Intent(this, FlyEnterActivity.class);
                startActivity(intent3);
                break;
            case 4:
                Intent intent4 = new Intent(this, ViewPagerActivity.class);
                startActivity(intent4);
                break;
            default:
                break;
        }

        toast(position);

    }

    private void toast(int position) {
        if (position == 0) {
            androidToast("呱呱呱。。。");
            return;
        }
        if (strings[position].contains("我的第"))
            androidToast("点击了" + strings[position]);
    }


    @Override
    protected void onResume() {
        super.onResume();
        Log.i("ssss","onResume");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.i("ssss","onRestart");
    }
}
