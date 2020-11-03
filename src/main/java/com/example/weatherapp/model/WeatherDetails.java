package com.example.weatherapp.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
public class WeatherDetails {
    private Double minTemp;
    private Double maxTemp;
    private String type;
    private String description;

    public WeatherDetails(Double minTemp, Double maxTemp, String type, String description) {
        this.minTemp = minTemp;
        this.maxTemp = maxTemp;
        this.type = type;
        this.description = description;
    }
}
