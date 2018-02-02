package com.wh.jxd.com.baseframework.presenter;

import android.view.View;

import com.wh.jxd.com.baseframework.view.BaseView;

/**
 * Created by kevin321vip on 2018/2/2.
 */

public class BasePresenter<V extends BaseView> {

    private V mView;
    /**
     * 绑定
     *
     * @param view
     */
    public void attachView(V view) {
        this.mView = view;
    }

    /**
     * 解绑
     */
    public void detachView() {
        mView = null;
    }

    public V getView() {
        if (mView == null) {
            throw new NullPointerException("View为空的!");
        } else {
            return mView;
        }
    }
}
