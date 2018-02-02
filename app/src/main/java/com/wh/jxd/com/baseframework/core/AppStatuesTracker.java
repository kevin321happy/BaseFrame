package com.wh.jxd.com.baseframework.core;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import android.util.Log;

import com.wh.jxd.com.baseframework.sonstants.ConstantValues;

/**
 * Created by kevin321vip on 2018/1/31.
 * app的状态追踪的类
 * 实现了ActivityLifecycleCallbacks, 监听所有的Activity的生命周期状态
 */

public class AppStatuesTracker implements Application.ActivityLifecycleCallbacks {
    private int mActivityCount;
    private static Application mApplication;
    private static AppStatuesTracker mAppStatuesTracker;
    private String TAG = "tracker";
    /**
     * app的状态
     */
    private int mAppStatus = ConstantValues.STATUS_NOT_LOGIN_IN;

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
     * 单例获取
     *
     * @return
     */
    public static AppStatuesTracker getInstance() {
        if (mAppStatuesTracker == null) {
            mAppStatuesTracker = new AppStatuesTracker(mApplication);
        }
        return mAppStatuesTracker;
    }

    /**
     * @param activity
     * @param savedInstanceState
     */
    @Override
    public void onActivityCreated(Activity activity, Bundle savedInstanceState) {
        Log.d(TAG, "当前的Activity:" + activity.toString() + ",onActivityCreated");
    }

    @Override
    public void onActivityStarted(Activity activity) {
        Log.d(TAG, "当前的Activity:" + activity.toString() + ",onActivityStarted");
        //走一次start就添加一次Activtiy
        mActivityCount++;
    }

    @Override
    public void onActivityResumed(Activity activity) {
        Log.d(TAG, "当前的Activity:" + activity.toString() + ",onActivityResumed");
    }

    @Override
    public void onActivityPaused(Activity activity) {
        Log.d(TAG, "当前的Activity:" + activity.toString() + ",onActivityPaused");
    }

    @Override
    public void onActivityStopped(Activity activity) {
        Log.d(TAG, "当前的Activity:" + activity.toString() + ",onActivityStopped");
        mActivityCount--;

    }

    @Override
    public void onActivitySaveInstanceState(Activity activity, Bundle outState) {
        Log.d(TAG, "当前的Activity:" + activity.toString() + ",onActivitySaveInstanceState");
    }

    @Override
    public void onActivityDestroyed(Activity activity) {
        Log.d(TAG, "当前的Activity:" + activity.toString() + ",onActivityDestroyed");
    }

    /**
     * 获取App的状态
     */
    public int getAppStatus() {
        return mAppStatus;
    }

    /**
     * 设置App的状态
     *
     * @param
     */
    public void setAppStatus(int appStatus) {
        this.mAppStatus = appStatus;
    }
}
