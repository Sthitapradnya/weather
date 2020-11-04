package com.example.weatherapp.model;

import lombok.Data;

@Data
public class City{
    public int id;
    public String name;
    public String state;
    public String country;
    public Coord coord;
}