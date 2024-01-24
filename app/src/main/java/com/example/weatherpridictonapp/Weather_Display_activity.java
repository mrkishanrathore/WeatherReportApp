package com.example.weatherpridictonapp;

import androidx.appcompat.app.AppCompatActivity;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import java.time.LocalTime;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Weather_Display_activity extends AppCompatActivity {
    public static String url = "https://api.open-meteo.com";
    EditText search_city ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weather_display);

        getValues(getLastLocation("latitude"),
                getLastLocation("longitude"),getLastLocation("city"));

    }

    public void getValues(String latitude,String longitute,String cityName){
        LocalTime currentTime = LocalTime.now();
        int currentHour = currentTime.getHour(); // 24-hour format

        search_city = findViewById(R.id.cityNameToSearch);

        RetrofitInstance.getInstance().apiInterface.getWeather(latitude, longitute,"temperature_2m,wind_speed_10m,cloud_cover").enqueue(new Callback<WeatherResponse>() {
            @Override
            public void onResponse(Call<WeatherResponse> call, Response<WeatherResponse> response) {
                Log.e("api", "onResponse: " + response.body().getHourly().getTemperature()[0]);
                setValues(cityName,String.valueOf(response.body().getHourly().getTemperature()[currentHour]),response.body().getHourly().getWind_speed_10m()[currentHour],response.body().getHourly().getCloud_cover()[currentHour]);
            }

            @Override
            public void onFailure(Call<WeatherResponse> call, Throwable t) {
                Log.e("api", "onFailure: "+t.getLocalizedMessage() );
            }
        });

    }

    public void setValues(String city, String temp, double windSpeed, double cloudy){
        TextView city_display = findViewById(R.id.city_display);
        TextView temp_display = findViewById(R.id.temp_display);
        TextView windSpeed_display = findViewById(R.id.windSpeed_display);
        TextView cloudy_display = findViewById(R.id.cloudy_display);
        TextView statusTextView = findViewById(R.id.status);
        ImageView statusImg = findViewById(R.id.statusImg);

        String status ;
        double temperature = Double.parseDouble(temp);
        if (temperature < 0) {
            status = "Freezing";
            statusImg.setImageResource(R.drawable.snowy);
        } else if (temperature >= 0 && temperature < 10) {
            status = "Cold";
            statusImg.setImageResource(R.drawable.partlysnowy);
        } else if (temperature >= 10 && temperature < 20) {
            status = "Cool";
            statusImg.setImageResource(R.drawable.partlycloudy);
        } else if (temperature >= 20 && temperature < 30) {
            status = "Moderate";
            statusImg.setImageResource(R.drawable.humid);
        } else if (temperature >= 30) {
            status = "Hot";
            statusImg.setImageResource(R.drawable.sunny);
        } else {
            status = "Unknown"; // Handle any other cases
            statusImg.setImageResource(R.drawable.cloud);
        }

        statusTextView.setText(status);
        city_display.setText(city);
        windSpeed_display.setText(String.format("Wind Speed : %sm/s", windSpeed));
        temp_display.setText(String.format("%s°C", temp));
        cloudy_display.setText(String.format("Cloud Density : %s%%", cloudy));
    }

    public String getLastLocation(String key){
        String def = "UnKnown";
            SharedPreferences sharedPreferences = getSharedPreferences(
                    "curloc", MODE_PRIVATE);
            return sharedPreferences.getString(key, def);
    }

    public void search(View view){
        EditText cityName = findViewById(R.id.cityNameToSearch);
        if(cityName.getText() == null){
            Toast.makeText(this, "Please Enter a city name.", Toast.LENGTH_SHORT).show();
        }else{
            try {
                RetrofitInstanceCity.getInstance().cityLocInterface.getLocation(String.valueOf(cityName.getText())).enqueue(new Callback<CityLocResponse>() {
                    @Override
                    public void onResponse(Call<CityLocResponse> call, Response<CityLocResponse> response) {
                        if(response.body() == null || response.body().getResults() == null) {
                            Toast.makeText(Weather_Display_activity.this, "Please Enter correct city name.", Toast.LENGTH_SHORT).show();
                            return;
                        }
                        getValues(String.valueOf(response.body().getResults().get(0).getLatitude()),String.valueOf(response.body().getResults().get(0).getLongitude()), String.valueOf(cityName.getText()));
                    }

                    @Override
                    public void onFailure(Call<CityLocResponse> call, Throwable t) {
                        Log.e("api", "onFailure: "+t.getLocalizedMessage() );
                    }
                });

            }catch (Exception e){
                Toast.makeText(this, "Please Enter correct city name.", Toast.LENGTH_SHORT).show();
            }
            
        }
    }

}