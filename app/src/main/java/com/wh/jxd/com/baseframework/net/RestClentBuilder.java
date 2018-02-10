package com.wh.jxd.com.baseframework.net;

import com.wh.jxd.com.baseframework.net.callback.IError;
import com.wh.jxd.com.baseframework.net.callback.IFail;
import com.wh.jxd.com.baseframework.net.callback.IProgress;
import com.wh.jxd.com.baseframework.net.callback.IStart;
import com.wh.jxd.com.baseframework.net.callback.ISuccess;

import java.util.WeakHashMap;

/**
 * Created by kevin321vip on 2018/2/8.
 * RestClient的构建者
 */

public final class RestClentBuilder {

    private String URL;
    private IStart ISTART;
    private ISuccess ISUCCESS;
    private IFail IFAIL;
    private IError IERROR;
    private IProgress IPROGRESS;
    private WeakHashMap<String, Object> PARAMS;

    public final RestClentBuilder url(String url) {
        this.URL = url;
        return this;
    }

    public final RestClentBuilder Istart(IStart iStart){
        this.ISTART=iStart;
        return this;
    }

    public final RestClentBuilder Isuccess(ISuccess iSuccess) {
        this.ISUCCESS = iSuccess;
        return this;
    }

    public final RestClentBuilder Ifail(IFail iFail) {
        this.IFAIL = iFail;
        return this;
    }

    public final RestClentBuilder Ierror(IError iError) {
        this.IERROR = iError;
        return this;
    }

    public final RestClentBuilder Iprogress(IProgress iProgress) {
        this.IPROGRESS = iProgress;
        return this;
    }

    public final RestClentBuilder params(WeakHashMap<String, Object> params) {
        this.PARAMS = params;
        return this;
    }

    /**
     * build方法返回构建好的RestClient
     *
     * @return
     */
    public RestClient build() {
        return new RestClient(URL, ISTART,ISUCCESS, IFAIL, IERROR, IPROGRESS, PARAMS);
    }
}
