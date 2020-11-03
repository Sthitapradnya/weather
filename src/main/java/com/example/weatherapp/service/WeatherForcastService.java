package com.example.weatherapp.service;

import com.example.weatherapp.client.WeatherApiClient;
import com.example.weatherapp.model.Forcast;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WeatherForcastService {

    @Autowired
    private WeatherApiClient weatherApiClient;
    public Forcast getWeatherForcastById(String id) {
        return weatherApiClient.getWeatherForcastById(id);
    }

}
