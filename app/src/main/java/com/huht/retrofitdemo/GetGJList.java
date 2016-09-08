package com.huht.retrofitdemo;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by huht on 2016/9/7.
 */
public interface GetGJList {
    @GET("param")
    Call<Id> contributors(
            @Query("id") String id);
}