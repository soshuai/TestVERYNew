package com.example.veryw.testveryssssss;

import java.io.File;
import java.util.UUID;

import android.content.Context;
import android.os.Environment;

import com.example.veryw.testveryssssss.util.LogUtils;
import com.example.veryw.testveryssssss.util.SdkUtils;
import com.example.veryw.testveryssssss.util.SpfUtils;
import com.example.veryw.testveryssssss.util.StringUtils;

/**
 * 应用程序配置类：用于保存用户相关信息及设置
 */
public class AppConfig {

    public static final String  DATA_LOAD_NEW             = "new";
    public static final String  DATA_LOAD_ADD             = "add";

    public static final int     MAIN_PAGER_COUNT          = 1;

    /** 自动更新开关 */
    public static final boolean AUTO_UPDATE               = true;
    private static AppConfig    appConfig;

    /** 消息提示-声音播放的间隔时间 */
    public static final long    MSG_NOTIFY_SOUND_INTERVAL = 2 * 1000;

    public static final int     INVITE_CODE_LENGTH        = 6;

    /** 默认缓存路径 */
    public static String        PATH_CACHE_DEFAULT;
    /** 图片缓存路径 */
    public static String        PATH_IMAGE_CACHE;
    /** 下载缓存路径 */
    public static String        PATH_DOWNLOAD_CACHE;

    private Context             mContext;

    public static boolean       isBigARM                  = false;

    public static AppConfig getAppConfig(Context context) {
        if (null == appConfig) {
            appConfig = new AppConfig(context);
            // 使用ApplicationContext避免在非AppContext中调用时 引起的内存泄漏
            appConfig.mContext = context.getApplicationContext();
        }
        return appConfig;
    }

    private AppConfig(Context context) {
        if (SdkUtils.checkSdCard()) {
            PATH_CACHE_DEFAULT = Environment.getExternalStorageDirectory().getAbsolutePath() + File.separator
                    + context.getPackageName();
            new File(PATH_CACHE_DEFAULT).mkdirs();
        } else {
            PATH_CACHE_DEFAULT = context.getCacheDir().getAbsolutePath();
        }
        LogUtils.e("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@", PATH_CACHE_DEFAULT);

        PATH_IMAGE_CACHE = PATH_CACHE_DEFAULT + File.separator + "image";
        new File(PATH_IMAGE_CACHE).mkdir();
        PATH_DOWNLOAD_CACHE = PATH_CACHE_DEFAULT + File.separator + "dl";
        new File(PATH_DOWNLOAD_CACHE).mkdir();
        // 手机内存>2G为标识为大内存设备
        if (SdkUtils.hasJellyBean_4_1()) {
            isBigARM = (2 * 1024 * 1024 * 0.8) > SdkUtils.getDeviceARMSize(context);
        }
    }

    public static final String CONF_APP_UNIQUEID = "conf_app_uniqueid";

    /**
     * 获取App唯一标识
     * 
     * @return
     */
    public String getAppId() {
        String uniqueID = SpfUtils.getString(mContext, AppConfig.CONF_APP_UNIQUEID);
        if (StringUtils.isEmpty(uniqueID)) {
            uniqueID = UUID.randomUUID().toString();
            SpfUtils.saveString(mContext, CONF_APP_UNIQUEID, uniqueID);
        }
        return uniqueID;
    }
  
}
