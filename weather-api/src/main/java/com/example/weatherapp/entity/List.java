package com.example.weatherapp.entity;

import lombok.Data;

@Data
public class List{
    private int dt;
    private Main main;
    private java.util.List<Weather> weather;
    private int visibility;
    private double pop;
    private String dt_txt;
}