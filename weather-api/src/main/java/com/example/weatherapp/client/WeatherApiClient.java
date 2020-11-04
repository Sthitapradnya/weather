package com.example.weatherapp.client;

import com.example.weatherapp.entity.WeatherResponse;
import com.example.weatherapp.model.Forcast;
import com.example.weatherapp.model.WeatherDetails;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.HttpServerErrorException;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class WeatherApiClient {

    @Autowired
    private RestTemplate restTemplate;

    @Value("${weather-app.api.key}")
    private String key;

    @Value("${weather-app.api.url}")
    private String url;

    public Forcast getWeatherForcastById(String id) {
        try {
            String fullUrl = url + "?id=" + id + "&appid=" + key;
            ResponseEntity<WeatherResponse> response = restTemplate.getForEntity(fullUrl, WeatherResponse.class);
            WeatherResponse weatherResponse = response.getBody();
            Forcast forcast = new Forcast();
            forcast.setCity(weatherResponse.getCity().getName());
            List<WeatherDetails> weatherDetails = new ArrayList<>();
             List<com.example.weatherapp.entity.List>lists = weatherResponse.getList().stream()
                     .sorted(Comparator.comparing(com.example.weatherapp.entity.List::getDt)).limit(3).collect(Collectors.toList());
             for (com.example.weatherapp.entity.List l : lists) {
                 WeatherDetails  weatherDetail = new WeatherDetails();
                 weatherDetail.setMaxTemp(l.getMain().getTemp_max());
                 weatherDetail.setMinTemp(l.getMain().getTemp_min());
                 weatherDetail.setDescription(l.getWeather().get(0).getDescription());
                 weatherDetail.setType(l.getWeather().get(0).getMain());
                 weatherDetail.setDate(l.getDt());
                 weatherDetails.add(weatherDetail);
             }
             forcast.setDetails(weatherDetails);
             return forcast;


        } catch (HttpClientErrorException e) {
            System.out.println(e.getLocalizedMessage());
            throw new RuntimeException("Client side ");
        } catch (HttpServerErrorException e) {
            System.out.println(e.getLocalizedMessage());
            throw new RuntimeException("Server side ");
        } catch (Exception e) {
            throw new RuntimeException("Error parsing JSON");
        }

    }
}
