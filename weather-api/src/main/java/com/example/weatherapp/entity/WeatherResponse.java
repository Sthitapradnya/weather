package com.example.weatherapp.entity;

import lombok.Data;

import java.util.List;

@Data
public class WeatherResponse {
        private String cod;
        private int message;
        private int cnt;
        private List<com.example.weatherapp.entity.List> list;
        private City city;
}
