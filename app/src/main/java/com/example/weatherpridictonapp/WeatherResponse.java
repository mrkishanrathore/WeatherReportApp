package com.example.weatherpridictonapp;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.lang.Double;
import java.lang.Integer;
import java.lang.String;

public class WeatherResponse implements Serializable {
    private Double elevation;
    private Hourly_units hourly_units;

    private Double generationtime_ms;

    private String timezone_abbreviation;

    private String timezone;

    private Double latitude;

    private Integer utc_offset_seconds;

    private Double longitude;

    private Hourly hourly;

    public Hourly getHourly() {
        return hourly;
    }

    public void setHourly(Hourly hourly) {
        this.hourly = hourly;
    }

    public Double getElevation() {
        return this.elevation;
    }

    public void setElevation(Double elevation) {
        this.elevation = elevation;
    }

    public Hourly_units getHourly_units() {
        return this.hourly_units;
    }

    public void setHourly_units(Hourly_units hourly_units) {
        this.hourly_units = hourly_units;
    }

    public Double getGenerationtime_ms() {
        return this.generationtime_ms;
    }

    public void setGenerationtime_ms(Double generationtime_ms) {
        this.generationtime_ms = generationtime_ms;
    }

    public String getTimezone_abbreviation() {
        return this.timezone_abbreviation;
    }

    public void setTimezone_abbreviation(String timezone_abbreviation) {
        this.timezone_abbreviation = timezone_abbreviation;
    }

    public String getTimezone() {
        return this.timezone;
    }

    public void setTimezone(String timezone) {
        this.timezone = timezone;
    }

    public Double getLatitude() {
        return this.latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public Integer getUtc_offset_seconds() {
        return this.utc_offset_seconds;
    }

    public void setUtc_offset_seconds(Integer utc_offset_seconds) {
        this.utc_offset_seconds = utc_offset_seconds;
    }

    public Double getLongitude() {
        return this.longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    public static class Hourly_units implements Serializable {
        private String temperature_2m;

        public String getTemperature_2m() {
            return this.temperature_2m;
        }

        public void setTemperature_2m(String temperature_2m) {
            this.temperature_2m = temperature_2m;
        }
    }

    class Hourly{
        private String[] times;
        private double[] temperature_2m;
        private double[] wind_speed_10m;

        private double[] cloud_cover;

        public double[] getCloud_cover() {
            return cloud_cover;
        }

        public void setCloud_cover(double[] cloud_cover) {
            this.cloud_cover = cloud_cover;
        }

        public String[] getTimes() {
            return times;
        }

        public double[] getWind_speed_10m() {
            return wind_speed_10m;
        }

        public void setWind_speed_10m(double[] wind_speed_10m) {
            this.wind_speed_10m = wind_speed_10m;
        }

        public double[] getTemperature() {
            return temperature_2m;
        }

        public void setTimes(String[] times) {
            this.times = times;
        }

        public void setTemperature(double[] temperature) {
            this.temperature_2m = temperature;
        }
    }

}
