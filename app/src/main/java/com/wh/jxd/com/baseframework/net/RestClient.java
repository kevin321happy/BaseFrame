package com.wh.jxd.com.baseframework.net;

import android.content.Context;


import com.wh.jxd.com.baseframework.net.callback.IError;
import com.wh.jxd.com.baseframework.net.callback.IFailed;
import com.wh.jxd.com.baseframework.net.callback.IStart;
import com.wh.jxd.com.baseframework.net.callback.ISuccess;
import com.wh.jxd.com.baseframework.net.loader.LoadStyle;
import com.wh.jxd.com.baseframework.net.loader.LyonLoader;
import com.wh.jxd.com.baseframework.utils.NetUtils;

import java.util.WeakHashMap;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import okhttp3.RequestBody;

/**
 * Created by kevin321vip on 2017/12/15.
 * 网络请求的客户端
 */
public class RestClient {
    private WeakHashMap<String, Object> PARAMS = RestCreator.getParams();
    private final String URL;
    private final IStart START;
    private final ISuccess SUCCESS;
    private final IFailed FAILED;
    private final IError ERROR;
    private final LoadStyle LOAD_STYLE;
    private final String NAME;
    private final RequestBody REQUEST_BODY;
    private final Context CONTEXT;

    public RestClient(String URL, IStart START, ISuccess SUCCESS, IFailed FAILED, IError ERROR, LoadStyle LOAD_STYLE, String NAME, RequestBody REQUEST_BODY, Context CONTEXT, WeakHashMap<String, Object> PARAMS) {
        this.URL = URL;
        this.START = START;
        this.SUCCESS = SUCCESS;
        this.FAILED = FAILED;
        this.ERROR = ERROR;
        this.LOAD_STYLE = LOAD_STYLE;
        this.NAME = NAME;
        this.REQUEST_BODY = REQUEST_BODY;
        this.CONTEXT = CONTEXT;
        this.PARAMS = PARAMS;
    }
    /**
     * Builder模式
     * @return
     */
    public static RestClientBuilder builder() {
        return new RestClientBuilder();
    }
    /**
     * 发起请求
     */
    public void request(HttpMethod method) {
        final RestService service = RestCreator.getService();
        Observable<String> observable = null;
        switch (method) {
            case GET:
                observable = service.get(URL, PARAMS);
                break;
            case POST:
                observable = service.post(URL, PARAMS);
                break;
            case PUT:
                observable = service.put(URL, PARAMS);
                break;
            default:
                break;
        }
        if (observable != null) {
            observable.subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .safeSubscribe(new Observer<String>() {
                        @Override
                        public void onSubscribe(Disposable d) {
                            if (START != null) {
                                START.onStart();
                            }
                            if (LOAD_STYLE != null) {
                                LyonLoader.showLoading(CONTEXT, LOAD_STYLE);
                            } else {
                                if (CONTEXT != null) {
                                    LyonLoader.showLoading(CONTEXT);
                                }
                            }
                        }
                        @Override
                        public void onNext(String s) {
                            if (CONTEXT != null) {
                                LyonLoader.stopLoading();
                            }
                            if (NetUtils.checkIsLogined(s)) {
                                if (FAILED != null) {
                                    FAILED.onFail("-99");
                                }
                                return;
                            }
                            if (!NetUtils.isRight(s)) {
                                if (FAILED != null) {
                                    FAILED.onFail(NetUtils.getInfo(s));
                                }
                            } else if (NetUtils.isRight(s)) {
                                if (SUCCESS != null) {
                                    SUCCESS.onSuccess(NetUtils.getData(s));
                                }
                            }
                        }
                        @Override
                        public void onError(Throwable e) {
                            if (CONTEXT != null) {
                                LyonLoader.stopLoading();
                            }
                            if (ERROR != null) {
                                ERROR.onError(-1, e.getMessage());
                            }
                        }
                        @Override
                        public void onComplete() {
                        }
                    });
        }
    }
    /**
     * get方法
     */
    public void get() {
        request(HttpMethod.GET);
    }
    /**
     * post请求
     */
    public void post() {
        request(HttpMethod.POST);
    }
}
