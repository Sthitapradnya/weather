package com.example.weatherapp.entity;

import lombok.Data;

import java.util.List;

@Data
public class WeatherResponse {

    private List<Detail> list;
}
