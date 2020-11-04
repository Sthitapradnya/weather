package com.example.weatherapp.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
public class Forcast {
    private String city;
    private List<WeatherDetails> details;

    public Forcast(String city, List<WeatherDetails> details) {
        this.city = city;
        this.details = details;
    }
}
