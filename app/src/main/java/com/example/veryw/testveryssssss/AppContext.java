package com.example.veryw.testveryssssss;

import android.app.Application;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatDelegate;

import com.example.veryw.testveryssssss.util.DynamicTimeFormat;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.DefaultRefreshHeaderCreater;
import com.scwang.smartrefresh.layout.api.RefreshHeader;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.header.ClassicsHeader;

/**
 * 全局应用程序类：用于数据初始化
 */
public final class AppContext extends Application {
    public static final String     APK_NAME        = "whbapp";
    public static final String     KEY_NEW_VERSION = "new_version";

    private static AppContext      mApp;

    static {
        AppCompatDelegate.setCompatVectorFromResourcesEnabled(true);
        SmartRefreshLayout.setDefaultRefreshHeaderCreater(new DefaultRefreshHeaderCreater() {
            @NonNull
            @Override
            public RefreshHeader createRefreshHeader(Context context, RefreshLayout layout) {
                layout.setPrimaryColorsId(R.color.light_gray2, R.color.black);//全局设置主题颜色
                return new ClassicsHeader(context).setTimeFormat(new DynamicTimeFormat("更新于 %s"));
            }
        });
    }

    @Override
    public void onCreate() {
        super.onCreate();
        mApp = this;
        init();
    }

    /**
     * 初始化
     */
    public void init() {
      /*  VcPlayerLog.enableLog();
        //初始化播放器
        AliVcMediaPlayer.init(getApplicationContext());
        ////设置保存密码。此密码如果更换，则之前保存的视频无法播放
        //AliyunDownloadConfig config = new AliyunDownloadConfig();
        //config.setSecretImagePath(Environment.getExternalStorageDirectory().getAbsolutePath()+"/aliyun/encryptedApp.dat");
        ////        config.setDownloadPassword("123456789");
        ////设置保存路径。请确保有SD卡访问权限。
        //config.setDownloadDir(Environment.getExternalStorageDirectory().getAbsolutePath()+"/test_save/");
        ////设置同时下载个数
        //config.setMaxNums(2);

        //AliyunDownloadManager.getInstance(this).setDownloadConfig(config);*/


//        if (LeakCanary.isInAnalyzerProcess(this)) {
//            // This process is dedicated to LeakCanary for heap analysis.
//            // You should not init your app in this process.
//            return;
//        }
//        LeakCanary.install(this);
    }

}
