/*
package com.huht.retrofitdemo.util;

import okhttp3.Cache;
import okhttp3.OkHttpClient;

*
 * Created by huht on 2016/9/8.


public enum OKHttpFactory {

    INSTANCE;

    private final OkHttpClient okHttpClient;

    private static final int TIMEOUT_READ = 25;
    private static final int TIMEOUT_CONNECTION = 25;

    OKHttpFactory() {
        //打印请求Log
        LoggerInterceptor interceptor = new LoggerInterceptor("huht");

        //缓存目录
        Cache cache = new Cache(MyApplication.mContext.getCacheDir(), 10 * 1024 * 1024);

        okHttpClient = new OkHttpClient.Builder()
                //打印请求log
                .addInterceptor(interceptor)

                //stetho,可以在chrome中查看请求
                .addNetworkInterceptor(new StethoInterceptor())

                //添加UA
                .addInterceptor(new UserAgentInterceptor(HttpHelper.getUse

rAgent()))

                //必须是设置Cache目录
                .cache(cache)

                //走缓存，两个都要设置
                .addInterceptor(new OnOffLineCachedInterceptor())
                .addNetworkInterceptor(new OnOffLineCachedInterceptor())

                //失败重连
                .retryOnConnectionFailure(true)

                //time out
                .readTimeout(TIMEOUT_READ, TimeUnit.SECONDS)
                .connectTimeout(TIMEOUT_CONNECTION, TimeUnit.SECONDS)

                .build();
    }

    public OkHttpClient getOkHttpClient() {
        return okHttpClient;
    }
}
}
*/
