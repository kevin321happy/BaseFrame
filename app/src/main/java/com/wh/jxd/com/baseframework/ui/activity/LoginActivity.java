package com.wh.jxd.com.baseframework.ui.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TextInputEditText;
import android.support.v7.widget.Toolbar;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.wh.jxd.com.baseframework.R;
import com.wh.jxd.com.baseframework.core.BaseMvpActivtiy;
import com.wh.jxd.com.baseframework.presenter.LoginPresenter;
import com.wh.jxd.com.baseframework.view.LoginView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by kevin321vip on 2018/2/2.
 */
public class LoginActivity extends BaseMvpActivtiy<LoginPresenter, LoginView> implements LoginView {
    @BindView(R.id.toolbar_title)
    TextView mToolbarTitle;
    @BindView(R.id.toolbar)
    Toolbar mToolbar;
    @BindView(R.id.et_number)
    TextInputEditText mEtNumber;
    @BindView(R.id.et_psw)
    TextInputEditText mEtPsw;
    @BindView(R.id.btn_login)
    Button mBtnLogin;
    private LoginPresenter mLoginPresenter;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login, R.string.login_title);
        ButterKnife.bind(this);
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

    @OnClick(R.id.btn_login)
    public void onViewClicked() {
        String number = mEtNumber.getText().toString();
        String psw = mEtPsw.getText().toString().trim();
        //在P层来做登陆参数验证的逻辑
        creatPresenter().checkLogin(number, psw);
    }
    @Override
    public void onCheckFail(String s) {
        Toast.makeText(this, s, Toast.LENGTH_SHORT).show();

    }

    @Override
    public void onLoginSuccess(String s) {
        Toast.makeText(this, s, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onLoginFail(String s) {
        Toast.makeText(this, s, Toast.LENGTH_SHORT).show();
    }
}
