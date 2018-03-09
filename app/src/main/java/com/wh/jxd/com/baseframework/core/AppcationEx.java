package com.wh.jxd.com.baseframework.core;

import android.app.Application;
import android.content.Context;

import com.wh.jxd.com.baseframework.service.InitializeService;

/**
 * Created by kevin321vip on 2018/2/2.
 */
public class AppcationEx extends Application {
    private static Context mContext;

    @Override
    public void onCreate() {
        super.onCreate();
        AppcationEx.mContext = getAppContext();
        //初始化App状态跟踪
        AppStatuesTracker.init(this);
        //在服务中统一做初始化工作
        InitializeService.start(this);
    }

    public static Context getAppContext() {
        return mContext;
    }


}
