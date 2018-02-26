package com.wh.jxd.com.baseframework.net;

import com.wh.jxd.com.baseframework.net.callback.IError;
import com.wh.jxd.com.baseframework.net.callback.IFail;
import com.wh.jxd.com.baseframework.net.callback.IProgress;
import com.wh.jxd.com.baseframework.net.callback.IStart;
import com.wh.jxd.com.baseframework.net.callback.ISuccess;
import com.wh.jxd.com.baseframework.utils.NetStateUtils;
import com.wh.jxd.com.baseframework.utils.NetUtils;

import java.util.WeakHashMap;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import retrofit2.http.Url;

/**
 * Created by kevin321vip on 2018/2/8.
 * 发起网络请求的客户端
 */

public class RestClient {
    private String mUrl;
    private IStart mIStart;
    private ISuccess mISuccess;
    private IFail mIFail;
    private IError mIError;
    private IProgress mIProgress;
    private WeakHashMap<String, Object> mParams;


    public RestClient(String url, IStart iStart, ISuccess ISuccess, IFail IFail, IError IError, IProgress IProgress, WeakHashMap<String, Object> params) {
        this.mUrl = url;
        this.mIStart = iStart;
        this.mISuccess = ISuccess;
        this.mIFail = IFail;
        this.mIError = IError;
        this.mIProgress = IProgress;
        this.mParams = params;
    }

    private static RestClentBuilder Builder() {
        return new RestClentBuilder();
    }

    /**
     * 发起请求
     *
     * @param method
     */
    public void Request(HttpMethod method) {
        RestService service = RestCreator.getService();
        Observable<String> observable = null;
        switch (method) {
            case GET:
                observable = service.get(mUrl, mParams);
                break;
            case POST:
                observable = service.post(mUrl, mParams);
                break;
            case DELETE:
                observable = service.delete(mUrl, mParams);
                break;
            case PUT:
                observable = service.put(mUrl, mParams);
                break;
        }
        //发起网络请求
        if (observable != null) {
            observable.subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe(new Observer<String>() {
                        @Override
                        public void onSubscribe(Disposable d) {
                            if (mIStart != null) {
                                mIStart.onStart();
                            }
                        }
                        @Override
                        public void onNext(String s) {
                            if (NetUtils.isRight(s)) {
                                if (mISuccess != null) {
                                    mISuccess.onSuccess(NetUtils.getData(s));
                                }
                            } else {
                                if (mIFail != null) {
                                    mIFail.onFail(NetUtils.getInfo(s));
                                }
                            }
                        }
                        @Override
                        public void onError(Throwable e) {
                            if (mIFail != null) {
                                mIFail.onFail(e.getMessage());
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
        Request(HttpMethod.GET);
    }

    /**
     * post方法
     */
    public void post() {
        Request(HttpMethod.POST);
    }
}
