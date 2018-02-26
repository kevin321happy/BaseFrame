package com.wh.jxd.com.baseframework.net;

import java.util.Observable;
import java.util.WeakHashMap;


import okhttp3.RequestBody;
import retrofit2.http.DELETE;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.QueryMap;
import retrofit2.http.Url;

/**
 * Created by kevin321vip on 2018/2/7.
 * 网络请求的Service
 */

public interface RestService {
    /**
     * get请求
     * @param url
     * @param
     * @return
     */
    @GET
    io.reactivex.Observable<String> get(@Url String url, @QueryMap WeakHashMap<String, Object> params);

    /**
     * post方法
     *
     * @param url
     * @param params
     * @return
     */
    @FormUrlEncoded

    @POST
    io.reactivex.Observable<String> post(@Url String url, @QueryMap WeakHashMap<String, Object> params);

    /**
     * postBody参数
     */
    @POST
    io.reactivex.Observable<String> post(@Url String url, RequestBody body);

    /**
     * put方法
     */
    @PUT
    io.reactivex.Observable<String> put(@Url String url, WeakHashMap<String, Object> params);

    /**
     * delete方法
     *
     * @param url
     * @param params
     * @return
     */
    @DELETE
    io.reactivex.Observable<String> delete(@Url String url, WeakHashMap<String, Object> params);
}
