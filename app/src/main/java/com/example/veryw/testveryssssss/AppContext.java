package com.example.veryw.testveryssssss;

import android.app.Application;
/**
 * 全局应用程序类：用于数据初始化
 */
public final class AppContext extends Application {
    public static final String     APK_NAME        = "whbapp";
    public static final String     KEY_NEW_VERSION = "new_version";

    private static AppContext      mApp;

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

       
    }

}
