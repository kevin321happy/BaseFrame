package com.wh.jxd.com.baseframework.core;

import android.app.Application;

import com.wh.jxd.com.baseframework.service.InitializeService;

/**
 * Created by kevin321vip on 2018/2/2.
 */
public class AppcationEx extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        //初始化App状态跟踪
        AppStatuesTracker.init(this);
        //在服务中统一做初始化工作
        InitializeService.start(this);
    }
}
