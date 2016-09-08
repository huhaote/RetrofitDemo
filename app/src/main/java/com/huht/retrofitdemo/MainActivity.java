package com.huht.retrofitdemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.huht.retrofitdemo.bean.Id;
import com.huht.retrofitdemo.bean.Phone;
import com.huht.retrofitdemo.service.GetGJList;
import com.huht.retrofitdemo.service.PhoneService;
import com.huht.retrofitdemo.util.LoggerInterceptor;

import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    public static String baseUrl = "http://retrofit.devwiki.net/";

    public static String mobileUrl = "http://apis.baidu.com/apistore/";

    private Retrofit retrofit;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initRetrofit(mobileUrl);
        requestPhone();//4fd613b3d5984807d60737694437b7c4
    }

    private void initRetrofit(String url) {
        OkHttpClient.Builder builder = new OkHttpClient().newBuilder();
        if (BuildConfig.DEBUG) {
            //日志拦截器
            builder.addNetworkInterceptor(new LoggerInterceptor("TAG"));
        }
        OkHttpClient client = builder.build();

        // Create a very simple REST adapter which points the GitHub API.
        retrofit = new Retrofit.Builder().client(client)
                .baseUrl(url)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    private void request() {
        // Create an instance of our GitHub API interface.
        GetGJList GetGJList = retrofit.create(GetGJList.class);
        Call<Id> call = GetGJList.contributors("1");
        call.enqueue(new Callback<Id>() {
            @Override
            public void onResponse(Call<Id> call, Response<Id> response) {
                Log.i("Message", response.body().getDesc() + "");
            }

            @Override
            public void onFailure(Call<Id> call, Throwable t) {
                Log.i("Message", "Failed");
            }
        });
    }

    private void requestPhone() {
        // Create an instance of our GitHub API interface.
        PhoneService phoneService = retrofit.create(PhoneService.class);
        Call<Phone> call = phoneService.getResult("4fd613b3d5984807d60737694437b7c4","15658089576");
        call.enqueue(new Callback<Phone>() {
            @Override
            public void onResponse(Call<Phone> call, Response<Phone> response) {
                Log.i("Message", response.body().getRetData().getCity() + "");
            }

            @Override
            public void onFailure(Call<Phone> call, Throwable t) {
                Log.i("Message", "Failed");
            }
        });
    }

}
