package com.example.weatherapp.Entity;

import lombok.Data;

@Data
public class Detail {

    private long dt;
    private MainData main;
    private Weather weather;
}
