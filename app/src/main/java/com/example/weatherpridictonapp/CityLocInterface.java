package com.example.weatherpridictonapp;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface CityLocInterface {
    @GET("/v1/search")
    Call<CityLocResponse> getLocation(
            @Query("name") String cityName
    );
}
