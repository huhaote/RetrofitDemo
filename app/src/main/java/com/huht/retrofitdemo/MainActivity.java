package com.huht.retrofitdemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    public static String baseUrl = "http://retrofit.devwiki.net/";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        OkHttpClient.Builder builder = new OkHttpClient().newBuilder();
        if(BuildConfig.DEBUG){
            //日志拦截器
            builder.addNetworkInterceptor(new LoggerInterceptor("TAG"));
        }
        OkHttpClient client = builder.build();

        // Create a very simple REST adapter which points the GitHub API.
        Retrofit retrofit = new Retrofit.Builder().client(client)
                .baseUrl(baseUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        // Create an instance of our GitHub API interface.
        GetGJList GetGJList = retrofit.create(GetGJList.class);
        Call<Id> call = GetGJList.contributors("1");
        call.enqueue(new Callback<Id>() {
            @Override
            public void onResponse(Call<Id> call, Response<Id> response) {
                Log.i("Message",response.body().getDesc()+"");
            }

            @Override
            public void onFailure(Call<Id> call, Throwable t) {
                Log.i("Message","Failed");
            }
        });
    }
}
