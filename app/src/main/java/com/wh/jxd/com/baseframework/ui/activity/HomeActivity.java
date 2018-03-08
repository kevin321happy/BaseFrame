package com.wh.jxd.com.baseframework.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.view.View;

import com.wh.jxd.com.baseframework.R;
import com.wh.jxd.com.baseframework.core.AppStatuesTracker;
import com.wh.jxd.com.baseframework.core.BaseActivity;
import com.wh.jxd.com.baseframework.net.RestClient;
import com.wh.jxd.com.baseframework.net.callback.IFailed;
import com.wh.jxd.com.baseframework.net.callback.ISuccess;
import com.wh.jxd.com.baseframework.sonstants.ConstantValues;
import com.wh.jxd.com.baseframework.view.LoginView;

/**
 * Created by kevin321vip on 2018/2/2.
 */

public class HomeActivity extends BaseActivity {
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //在HomeActivity中进行状态的改变
        AppStatuesTracker.getInstance().setAppStatus(ConstantValues.STATUS_ALREADY_LOGGED);
        setContentView(R.layout.activity_main, R.string.home_title);
        //联网示例代码
//        RestClient.builder()
//                .url("www.baidu.com")
//                .success(new ISuccess() {
//                    @Override
//                    public void onSuccess(String data) {
//
//                    }
//                })
//                .fail(new IFailed() {
//                    @Override
//                    public void onFail(String message) {
//
//                    }
//                })
//                .build().get();

    }
    public void startLogin(View view) {
        Intent intent = new Intent(this, LoginActivity.class);
        startActivity(intent);
    }
}
