package com.wh.jxd.com.baseframework.service;

import android.app.Application;
import android.app.IntentService;
import android.content.Context;
import android.content.Intent;
import android.support.annotation.Nullable;

import com.wh.jxd.com.baseframework.core.AppStatuesTracker;

/**
 * Created by kevin321vip on 2018/2/2.
 */

public class InitializeService extends IntentService {
    private static Context mContext;
    private static final String ACTION_INIT_WHEN_APP_CREATE = "com.wh.jxd.com.refactorqm.service.action.INIT";

    /**
     * Creates an IntentService.  Invoked by your subclass's constructor.
     */
    public InitializeService() {
        super("InitializeService");
    }

    public static void start(Context context) {
        mContext = context;
        Intent intent = new Intent(context, InitializeService.class);
        intent.setAction(ACTION_INIT_WHEN_APP_CREATE);
        context.startService(intent);
    }

    @Override
    protected void onHandleIntent(@Nullable Intent intent) {
        if (intent != null) {
            String action = intent.getAction();
            if (ACTION_INIT_WHEN_APP_CREATE.equals(action)) {
                performInit();
            }
        }
    }

    /**
     * 应用启动初始化
     */
    private void performInit() {

    }
}