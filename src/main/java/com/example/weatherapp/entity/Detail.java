package com.example.weatherapp.entity;

import lombok.Data;

@Data
public class Detail {

    private long dt;
    private MainData main;
    private Weather weather;
}
