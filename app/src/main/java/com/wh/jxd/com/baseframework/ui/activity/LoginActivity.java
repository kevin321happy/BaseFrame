package com.wh.jxd.com.baseframework.ui.activity;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;

import com.wh.jxd.com.baseframework.R;
import com.wh.jxd.com.baseframework.core.BaseActivity;

/**
 * Created by kevin321vip on 2018/2/2.
 */

public class LoginActivity extends BaseActivity {

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login,R.string.login_title);

    }
}
