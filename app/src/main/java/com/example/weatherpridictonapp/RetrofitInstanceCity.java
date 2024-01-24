package com.example.weatherpridictonapp;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitInstanceCity {
    public static RetrofitInstanceCity Instance;
    CityLocInterface cityLocInterface;

    RetrofitInstanceCity(){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://geocoding-api.open-meteo.com")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        cityLocInterface = retrofit.create(CityLocInterface.class);
    }

    public static RetrofitInstanceCity getInstance() {
        if(Instance == null){
            Instance = new RetrofitInstanceCity();
        }
        return Instance;
    }
}
