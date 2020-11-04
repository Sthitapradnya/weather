package com.example.weatherapp.controller;

import com.example.weatherapp.model.City;
import com.example.weatherapp.model.CityRoot;
import com.example.weatherapp.model.Forcast;
import com.example.weatherapp.service.WeatherForcastService;
import com.example.weatherapp.service.WeatherService;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/weather")
@RequiredArgsConstructor
@CrossOrigin
public class WeatherController {

    @Autowired
    private WeatherService weatherForcastService;

    @GetMapping("/city/{id}")
    @ResponseBody
    public Forcast getWeatherForcastByCityId(@PathVariable("id") String id){
        return weatherForcastService.getWeatherForcastById(id);

    }

    @GetMapping("/cities")
    @ResponseBody
    public List<City> getListOfCities() throws IOException {
        File file = new File(this.getClass().getClassLoader().getResource("cities.json").getFile());
        ObjectMapper mapper = new ObjectMapper();
        CityRoot cities = mapper.readValue(file, CityRoot.class);
        return cities.cities;
    }
}
