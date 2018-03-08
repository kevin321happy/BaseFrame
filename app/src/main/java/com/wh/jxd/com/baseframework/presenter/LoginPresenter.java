package com.wh.jxd.com.baseframework.presenter;

import com.wh.jxd.com.baseframework.view.LoginView;

/**
 * Created by kevin321vip on 2018/2/2.
 */

public class LoginPresenter extends BasePresenter<LoginView> {

    private LoginView mLoginView;


    @Override
    public void attachView(LoginView view) {
        super.attachView(view);
        this.mLoginView = view;
    }


    public void checkLogin(String number, String psw) {
        if (number == null || number.length() == 0) {
            mLoginView.onCheckFail("手机号不能为空!");
            return;
        }
        if (psw == null || psw.length() < 5) {
            mLoginView.onCheckFail("至少设置6位数的密码!");
            return;
        }
        //TODO 开始登陆
        startLogin(number,psw);
    }

    /**
     * 开始登陆
     * @param number
     * @param psw
     */
    private void startLogin(String number, String psw) {
        //简单的模拟登陆，并将结果回调到V层
        if (number.length()==psw.length()){
            //登陆成功
            mLoginView.onLoginSuccess("登陆成功");
        }else {
            mLoginView.onLoginFail("登陆失败");
        }
    }
}
