package com.huht.retrofitdemo.util;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by huht on 2016/9/9.
 */
public enum RetrofitClient {

    INSTANCE;
    private Retrofit.Builder builder;

    RetrofitClient(){
        builder =  new Retrofit.Builder().client(OKHttpFactory.INSTANCE.getOkHttpClient())
                .addConverterFactory(GsonConverterFactory.create());
    }

    public Retrofit.Builder getBuilder(){
        return builder;
    }

    public Retrofit build(String url) {
        return builder.baseUrl(url).build();
    }
}
