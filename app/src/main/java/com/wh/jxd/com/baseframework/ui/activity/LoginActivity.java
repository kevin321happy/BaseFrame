package com.wh.jxd.com.baseframework.ui.activity;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;

import com.wh.jxd.com.baseframework.R;
import com.wh.jxd.com.baseframework.core.BaseActivity;
import com.wh.jxd.com.baseframework.core.BaseMvpActivtiy;
import com.wh.jxd.com.baseframework.presenter.LoginPresenter;
import com.wh.jxd.com.baseframework.view.LoginView;

/**
 * Created by kevin321vip on 2018/2/2.
 */

public class LoginActivity extends BaseMvpActivtiy<LoginPresenter, LoginView> implements LoginView {

    private LoginPresenter mLoginPresenter;
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login, R.string.login_title);
    }
    @Override
    protected LoginView creatView() {
        return this;
    }
    @Override
    public LoginPresenter creatPresenter() {
        if (mLoginPresenter == null) {
            mLoginPresenter = new LoginPresenter();
        }
        return mLoginPresenter;
    }
}
