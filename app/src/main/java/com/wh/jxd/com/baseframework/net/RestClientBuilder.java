package com.wh.jxd.com.baseframework.net;

import android.content.Context;


import com.wh.jxd.com.baseframework.net.callback.IError;
import com.wh.jxd.com.baseframework.net.callback.IFailed;
import com.wh.jxd.com.baseframework.net.callback.IStart;
import com.wh.jxd.com.baseframework.net.callback.ISuccess;
import com.wh.jxd.com.baseframework.net.loader.LoadStyle;

import java.util.WeakHashMap;

import okhttp3.RequestBody;

/**
 * Created by kevin321vip on 2017/12/15.
 * RestClient的构造器
 */

public class RestClientBuilder {

    private WeakHashMap<String, Object> PARAMS =RestCreator.getParams();
    private String URL;
    private IStart START;
    private ISuccess SUCCESS;
    private IFailed FAILED;
    private IError ERROR;
    private LoadStyle LOAD_STYLE;
    private String NAME;
    private RequestBody REQUEST_BODY;
    private Context CONTEXT;

    public final RestClientBuilder params(WeakHashMap<String, Object> params) {
        PARAMS.putAll(params);
        return this;
    }

    public final RestClientBuilder params(String key, Object value) {
        PARAMS.put(key, value);
        return this;
    }

    public final RestClientBuilder url(String url) {
        this.URL = url;
        return this;
    }

    public final RestClientBuilder start(IStart start) {
        this.START = start;
        return this;
    }

    public final RestClientBuilder success(ISuccess success) {
        this.SUCCESS = success;
        return this;
    }

    public final RestClientBuilder fail(IFailed failed) {
        this.FAILED = failed;
        return this;
    }

    public final RestClientBuilder error(IError error) {
        this.ERROR = error;
        return this;
    }

    public final RestClientBuilder name(String name) {
        this.NAME = name;
        return this;
    }

    public final RestClientBuilder requestBody(RequestBody requestBody) {
        this.REQUEST_BODY = requestBody;
        return this;
    }

    public final RestClientBuilder LoadStyle(LoadStyle loadStyle) {
        this.LOAD_STYLE = loadStyle;
        return this;
    }


    public final RestClientBuilder load(Context context, LoadStyle loadStyle) {
        this.CONTEXT = context;
        this.LOAD_STYLE = loadStyle;
        return this;
    }

    public final RestClientBuilder load(Context context) {
        this.CONTEXT = context;
        return this;
    }
    /**
     * 构建返回RestClient对象
     *
     * @return
     */
    public RestClient build() {
        return new RestClient(URL, START, SUCCESS, FAILED, ERROR, LOAD_STYLE, NAME, REQUEST_BODY, CONTEXT,PARAMS);
    }
}
