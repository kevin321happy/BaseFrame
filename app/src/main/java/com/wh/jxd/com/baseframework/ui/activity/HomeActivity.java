package com.wh.jxd.com.baseframework.ui.activity;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;

import com.wh.jxd.com.baseframework.core.AppStatuesTracker;
import com.wh.jxd.com.baseframework.core.BaseActivity;
import com.wh.jxd.com.baseframework.sonstants.ConstantValues;

/**
 * Created by kevin321vip on 2018/2/2.
 */

public class HomeActivity extends BaseActivity {

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        AppStatuesTracker.getInstance().setAppStatus(ConstantValues.STATUS_ALREADY_LOGGED);
    }
}
