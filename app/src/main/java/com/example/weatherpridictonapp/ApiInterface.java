package com.example.weatherpridictonapp;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiInterface {
    @GET("/v1/forecast")
    Call<WeatherResponse> getWeather(
            @Query("latitude") String latitude,
            @Query("longitude") String longitude,
            @Query("hourly") String hourlyParams
    );
}
