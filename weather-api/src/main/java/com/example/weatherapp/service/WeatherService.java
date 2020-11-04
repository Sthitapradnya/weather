package com.example.weatherapp.service;

import com.example.weatherapp.model.Forcast;

public interface WeatherService{
    public Forcast getWeatherForcastById(String id);
}
