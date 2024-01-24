package com.example.weatherpridictonapp;

import static com.example.weatherpridictonapp.Weather_Display_activity.url;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitInstance {
    public static RetrofitInstance Instance;
    ApiInterface apiInterface;

    RetrofitInstance(){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(url)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        apiInterface = retrofit.create(ApiInterface.class);
    }

    public static RetrofitInstance getInstance() {
        if(Instance == null){
            Instance = new RetrofitInstance();
        }
        return Instance;
    }
}
