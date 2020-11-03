package com.example.weatherapp.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
public class Forcast {
    private String city;
    private List<WeatherDetails> details;

    public Forcast(String city, List<WeatherDetails> details) {
        this.city = city;
        this.details = details;
    }
}
