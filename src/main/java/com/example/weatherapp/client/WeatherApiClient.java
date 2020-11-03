package com.example.weatherapp.client;

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
import java.util.List;

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
            ResponseEntity<String> response = restTemplate.getForEntity(fullUrl, String.class);
            ObjectMapper mapper = new ObjectMapper();
            JsonNode node = mapper.readTree(response.getBody());
//            System.out.println(node.toString());
            List<WeatherDetails> list = new ArrayList();
            for (int i = 0; i < 3; i++) {
                list.add(new WeatherDetails(node.path("list").get(i).path("main").path("temp_min").asDouble(),
                        node.path("list").get(i).path("main").path("temp_min").asDouble(),
                        node.path("list").get(i).path("weather").get(0).path("main").asText(),
                        node.path("list").get(i).path("weather").get(0).path("description").asText()));
            }
            return new Forcast(node.path("city").path("name").asText(), list);
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
