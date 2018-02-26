package com.wh.jxd.com.baseframework.net;

import java.util.WeakHashMap;
import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.scalars.ScalarsConverterFactory;

/**
 * Created by kevin321vip on 2018/2/8.
 * 构建联网的客户端
 */

public class RestCreator {
    /**
     * 静态内部类Hodler的方式构建Retrofit
     */

    private static final class RetrofitHodler {
        private static final Retrofit RETROFIT_CLIENT = new Retrofit.Builder().
                client(OkhttpHodler.OK_HTTP_CLIENT)
                .baseUrl("http://gank.io/api/")
                .addConverterFactory(ScalarsConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
    }

    /**
     * OkhttpHodler
     */
    private static final class OkhttpHodler {
        private static final OkHttpClient OK_HTTP_CLIENT = new OkHttpClient.Builder()
                .connectTimeout(10000, TimeUnit.SECONDS)
                .build();
    }

    /**
     * RestServiceHodler
     */
    private static final class RestServiceHodler {
        private static final RestService REST_SERVICE = RetrofitHodler.RETROFIT_CLIENT.create(RestService.class);
    }

    /**
     * PramasHodler
     */
    private static final class ParamsHodler {
        private static final WeakHashMap<String, Object> PARAMS = new WeakHashMap<>();
    }

    /**
     * 获取参数
     */
    public static WeakHashMap<String, Object> getParams() {
        return ParamsHodler.PARAMS;
    }

    /**
     * 获取Service
     */
    public static RestService getService() {
        return RestServiceHodler.REST_SERVICE;
    }
}
