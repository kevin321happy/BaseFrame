package com.wh.jxd.com.baseframework.view;

/**
 * Created by kevin321vip on 2018/2/2.
 */

public interface LoginView extends BaseView {
    void onCheckFail(String s);

    void onLoginSuccess(String s);

    void onLoginFail(String s);
}
