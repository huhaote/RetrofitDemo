package com.huht.retrofitdemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.huht.retrofitdemo.bean.Id;
import com.huht.retrofitdemo.bean.Phone;
import com.huht.retrofitdemo.service.Get;
import com.huht.retrofitdemo.service.PhoneService;
import com.huht.retrofitdemo.util.RetrofitClient;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class MainActivity extends AppCompatActivity {

    public static String baseUrl = "http://retrofit.devwiki.net/";

    public static String mobileUrl = "http://apis.baidu.com/apistore/";

    private Retrofit retrofit;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        requestPhone();//4fd613b3d5984807d60737694437b7c4
        request();
    }

    private void request() {
        retrofit = RetrofitClient.INSTANCE.build(baseUrl);
        retrofit.create(Get.class)
                .get("1")
                .enqueue(new Callback<Id>() {
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
        RetrofitClient.INSTANCE.build(mobileUrl)
                .create(PhoneService.class)
                .getResult("4fd613b3d5984807d60737694437b7c4", "15658089576")
                .enqueue(new Callback<Phone>() {
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
