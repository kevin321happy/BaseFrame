package com.wh.jxd.com.baseframework.net;



import com.wh.jxd.com.baseframework.core.AppcationEx;

import java.io.File;
import java.util.WeakHashMap;
import java.util.concurrent.TimeUnit;

import okhttp3.Cache;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.scalars.ScalarsConverterFactory;

/**
 * Created by kevin321vip on 2017/12/15.
 */

public class RestCreator {
    /**
     * Retrofithodler的Hodler
     */
    private static final class RetrofitHodler {
        private static final Retrofit RETROFIT_CLIENT = new Retrofit.Builder()
                .client(OkHttpClientHodler.OK_HTTP_CLIENT)
                .baseUrl(URLConstants.BASE_URL)
                .addConverterFactory(ScalarsConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
    }

    public static OkHttpClient getOkHttpClient() {
        //日志拦截器
//        OkHttpClient httpClient = OkHttpClientHodler.OK_HTTP_CLIENT;
        File cacheFile = new File(AppcationEx.getAppContext().getCacheDir(), "http_cache");
        Cache cache = new Cache(cacheFile, 1024 * 1024 * 10);//100M的缓存
        //设置拦截器
        OkHttpClient okHttpClient = new OkHttpClient.Builder()
                .readTimeout(URLConstants.TIME_OUT, TimeUnit.SECONDS)
                .connectTimeout(URLConstants.TIME_OUT, TimeUnit.MILLISECONDS)
//                .addInterceptor(interceptor)
                .addNetworkInterceptor(new HttpCacheInterceptor())
                .cache(cache)
                .build();
        return okHttpClient;
    }

    /**
     * okhttpclient的Hodler
     */
    public static final class OkHttpClientHodler {
        private static final OkHttpClient OK_HTTP_CLIENT = new OkHttpClient.Builder()
                .connectTimeout(URLConstants.TIME_OUT, TimeUnit.SECONDS)
                .build();
    }

    /**
     * RestService的Hodler
     */
    public static final class RestServiceHodler {
        private static final RestService REST_SERVICE = RetrofitHodler.RETROFIT_CLIENT.create(RestService.class);
    }
    /**
     * params的hodler
     */
    public static final class ParamsHodler {
        private static final WeakHashMap<String, Object> PARAMS = new WeakHashMap<>();
    }
    /**
     * 获取参数
     *
     * @return
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
