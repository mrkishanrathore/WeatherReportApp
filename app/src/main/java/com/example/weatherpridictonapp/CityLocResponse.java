package com.example.weatherpridictonapp;

import java.io.Serializable;
import java.lang.Double;
import java.lang.Integer;
import java.lang.String;
import java.util.List;

public class CityLocResponse implements Serializable {
    private Double generationtime_ms;

    private List<Results> results;

    public Double getGenerationtime_ms() {
        return this.generationtime_ms;
    }

    public void setGenerationtime_ms(Double generationtime_ms) {
        this.generationtime_ms = generationtime_ms;
    }

    public List<Results> getResults() {
        return this.results;
    }

    public void setResults(List<Results> results) {
        this.results = results;
    }

    public static class Results implements Serializable {
        private Double elevation;

        private String country;

        private Integer admin1_id;

        private String timezone;

        private Double latitude;

        private Integer population;

        private String country_code;

        private String name;

        private String admin1;

        private Integer id;

        private String feature_code;

        private Integer country_id;

        private Double longitude;


        public Double getElevation() {
            return this.elevation;
        }

        public void setElevation(Double elevation) {
            this.elevation = elevation;
        }

        public String getCountry() {
            return this.country;
        }

        public void setCountry(String country) {
            this.country = country;
        }

        public Integer getAdmin1_id() {
            return this.admin1_id;
        }

        public void setAdmin1_id(Integer admin1_id) {
            this.admin1_id = admin1_id;
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

        public Integer getPopulation() {
            return this.population;
        }

        public void setPopulation(Integer population) {
            this.population = population;
        }

        public String getCountry_code() {
            return this.country_code;
        }

        public void setCountry_code(String country_code) {
            this.country_code = country_code;
        }

        public String getName() {
            return this.name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getAdmin1() {
            return this.admin1;
        }

        public void setAdmin1(String admin1) {
            this.admin1 = admin1;
        }

        public Integer getId() {
            return this.id;
        }

        public void setId(Integer id) {
            this.id = id;
        }

        public String getFeature_code() {
            return this.feature_code;
        }

        public void setFeature_code(String feature_code) {
            this.feature_code = feature_code;
        }

        public Integer getCountry_id() {
            return this.country_id;
        }

        public void setCountry_id(Integer country_id) {
            this.country_id = country_id;
        }

        public Double getLongitude() {
            return this.longitude;
        }

        public void setLongitude(Double longitude) {
            this.longitude = longitude;
        }
    }
}
