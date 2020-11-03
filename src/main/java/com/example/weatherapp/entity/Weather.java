package com.example.weatherapp.entity;

import lombok.Data;

import java.util.List;

@Data
public class Weather {
    private List<DailyDetail> details;
}
