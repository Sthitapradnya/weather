package com.example.weatherapp.controller;

import com.example.weatherapp.model.Forcast;
import com.example.weatherapp.service.WeatherForcastService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/weather")
@RequiredArgsConstructor
public class WeatherController {

    @Autowired
    private WeatherForcastService weatherForcastService;

    @GetMapping("/forcast/{id}")
    @ResponseBody
    public Forcast getWeatherForcastByCityId(@PathVariable("id") String id){
        return weatherForcastService.getWeatherForcastById(id);

    }

    @GetMapping("/cities")
    @ResponseBody
    public List<String> getListOfCities() throws IOException {
        return Arrays.asList("833", "524901");
    }
}
