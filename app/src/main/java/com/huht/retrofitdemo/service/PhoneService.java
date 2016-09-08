package com.huht.retrofitdemo.service;

import com.huht.retrofitdemo.bean.Id;
import com.huht.retrofitdemo.bean.Phone;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Query;

/**
 * Created by huht on 2016/9/7.
 */
public interface PhoneService {
    @GET("mobilenumber/mobilenumber")
    Call<Phone> getResult(@Header("apikey") String apikey,
            @Query("phone") String phone);
}