package com.wh.jxd.com.baseframework.core;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;

import com.wh.jxd.com.baseframework.presenter.BasePresenter;
import com.wh.jxd.com.baseframework.view.BaseView;

/**
 * Created by kevin321vip on 2018/2/2.
 */

public abstract class BaseMvpActivtiy<P extends BasePresenter, V extends BaseView> extends BaseActivity {

    private P mPresenter;
    private V mView;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (mPresenter == null) {
            mPresenter = creatPresenter();
        }
        if (mPresenter == null) {
            throw new NullPointerException("Presneter不能为空!");
        }
        if (mView == null) {
            mView = creatView();
        }
        if (mView == null) {
            throw new NullPointerException("View不能为空!");
        }
        //P层和V层进行绑定
        mPresenter.attachView(mView);
    }

    /**
     * 得到View对象
     *
     * @return
     */
    protected abstract V creatView();

    /**
     * 抽象方法得到P对象
     *
     * @return
     */
    public abstract P creatPresenter();

    @Override
    protected void onDestroy() {
        super.onDestroy();
        //P层和V层解绑
        if (mPresenter!=null){
            mPresenter.detachView();
        }
    }
}
