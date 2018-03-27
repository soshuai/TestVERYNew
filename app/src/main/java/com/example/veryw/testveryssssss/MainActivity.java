package com.example.veryw.testveryssssss;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;

import com.example.veryw.testveryssssss.adapter.MyAdapter;
import com.example.veryw.testveryssssss.base.BaseActivity;
import com.example.veryw.testveryssssss.ftp.bussiness.BussinessUtil;
import com.example.veryw.testveryssssss.ftp.com.util.ConfigConst;
import com.example.veryw.testveryssssss.ftp.com.util.IpUtil;
import com.example.veryw.testveryssssss.ftp.run.GetWhiteListtask;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.logging.Logger;


public class MainActivity extends BaseActivity implements MyAdapter.RecyclerviewOnItemClickListenr {

    private RecyclerView rv;

    private LinearLayout linerlayout;
    private String[] strings;
    //测试  测试   测试

    private static final Logger logger = Logger.getLogger(String.valueOf(GetWhiteListtask.class));

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        /////////////////////
        //        setSwipeBackEnable(false);//禁掉左滑退出


        initView();
        //        m1(2);
        //        m1((Integer) 10);

//        Log.i("haiyangsb", "最终结果" + getNum());
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    String fileName = "hhh";
                    FileInputStream fis = openFileInput(fileName);
                    InputStreamReader isr = new InputStreamReader(fis, "utf-8");
                    char input[] = new char[fis.available()];
                    isr.read(input);
                    isr.close();
                    fis.close();
                    String readed = new String(input);
                    Log.i("vvvv", "读取内容：");
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                } catch (UnsupportedEncodingException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }).start();


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
        strings = new String[12];
        for (int i = 0; i < strings.length; i++) {
            strings[i] = "我的第" + (i + 1) + "个Demo";
        }
        strings[0] = "温水煮青蛙";
        strings[1] = "Rotate旋转动画";
        strings[2] = "3D画廊";
        strings[3] = "鹰击长空";
        strings[4] = "viewpager";
        strings[5] = "AR";
        strings[6] = "自定义View";
        strings[7] = "照相/相册";
        strings[8] = "PullToRefreshListView";
        strings[9] = "文件读取/写入";
        strings[10] = "ftp";
        strings[11] = "查找手机文件";
        return strings;
    }

    @Override
    public void onclickHaha(View view, int position) {
        switch (position) {
            case 0:
                Intent intent0 = new Intent(this, PushNewsDialog.class);
                startActivity(intent0);
                break;
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
            case 5:
                Intent intent5 = new Intent(this, ARActivity.class);
                startActivity(intent5);
                break;
            case 6:
                Intent intent6 = new Intent(this, ViewsActivity.class);
                startActivity(intent6);
                break;
            case 7:
                Intent intent7 = new Intent(this, PhotoActivity.class);
                startActivity(intent7);
                break;
            case 8:
                Intent intent8 = new Intent(this, PulltoRefreshActivity.class);
                startActivity(intent8);
                break;
            case 9:
                Intent intent9 = new Intent(this, FileReadWriteActivity.class);
                startActivity(intent9);
                break;
            case 10:
                BussinessUtil bussinessUtil = BussinessUtil.getInstance();
                try {
                    ConfigConst.getConfigConst();
                } catch (Exception e) {
                    Log.i("mmmm", "错误打印==" + e.toString());
                    e.printStackTrace();
                }
                logger.info("程序开始运行");
                Thread r = new Thread(new GetWhiteListtask(bussinessUtil));
                r.start();

                boolean ipCheckFlag = false;
                try {
                    ipCheckFlag = bussinessUtil.checkIPwhitelist(IpUtil.ipToLong("111.62.90.254"));
                } catch (IOException e) {
                    e.printStackTrace();
                }
                if (ipCheckFlag) {
                    System.out.println("111.62.90.254在其中");
                } else {
                    System.out.println("111.62.90.254不在其中");
                }
                break;
            case 11:
                Intent intent10= new Intent(this, SearchFileActivity.class);
                startActivity(intent10);
                break;
            default:
                break;
        }

        toast(position);

    }

    /**
     * @param position
     */
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
        Log.i("ssss", "onResume");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.i("ssss", "onRestart");
    }
}
