package com.example.weatherapp.entity;

import lombok.Data;

import java.util.List;

@Data
public class Weather{
    private int id;
    private String main;
    private String description;
    private String icon;
}
