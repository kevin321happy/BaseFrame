package com.wh.jxd.com.baseframework.net;

import com.wh.jxd.com.baseframework.net.callback.IError;
import com.wh.jxd.com.baseframework.net.callback.IFail;
import com.wh.jxd.com.baseframework.net.callback.IProgress;
import com.wh.jxd.com.baseframework.net.callback.ISuccess;

import java.util.WeakHashMap;

/**
 * Created by kevin321vip on 2018/2/8.
 * 发起网络请求的客户端
 */

public class RestClient {
    private String url;
    private ISuccess mISuccess;
    private IFail mIFail;
    private IError mIError;
    private IProgress mIProgress;
    private WeakHashMap<String, Object> mParams;


    public RestClient(String url, ISuccess ISuccess, IFail IFail, IError IError, IProgress IProgress, WeakHashMap<String, Object> params) {
        this.url = url;
        mISuccess = ISuccess;
        mIFail = IFail;
        mIError = IError;
        mIProgress = IProgress;
        mParams = params;
    }

    private static RestClentBuilder Builder() {
        return new RestClentBuilder();
    }
}
