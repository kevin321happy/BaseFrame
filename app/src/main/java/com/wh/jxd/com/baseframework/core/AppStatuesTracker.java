package com.wh.jxd.com.baseframework.core;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;

/**
 * Created by kevin321vip on 2018/1/31.
 * app的状态追踪的类
 * 实现了ActivityLifecycleCallbacks, 监听所有的Activity的生命周期状态
 */

public class AppStatuesTracker implements Application.ActivityLifecycleCallbacks {
    private int mActivityCount;
    private Application mApplication;
    private static AppStatuesTracker mAppStatuesTracker;

    /**
     * 构造方法传人Application
     *
     * @param application
     */
    private AppStatuesTracker(Application application) {
        this.mApplication = application;
        //注册
        application.registerActivityLifecycleCallbacks(this);
    }

    public static void init(Application application) {
        mAppStatuesTracker = new AppStatuesTracker(application);
    }

    /**
     * 单例获取对象
     * @param activity
     * @param savedInstanceState
     */


    @Override
    public void onActivityCreated(Activity activity, Bundle savedInstanceState) {

    }

    @Override
    public void onActivityStarted(Activity activity) {
        //走一次start就添加一次Activtiy
        mActivityCount++;

    }

    @Override
    public void onActivityResumed(Activity activity) {

    }

    @Override
    public void onActivityPaused(Activity activity) {

    }

    @Override
    public void onActivityStopped(Activity activity) {
        mActivityCount--;

    }

    @Override
    public void onActivitySaveInstanceState(Activity activity, Bundle outState) {

    }

    @Override
    public void onActivityDestroyed(Activity activity) {

    }
}
