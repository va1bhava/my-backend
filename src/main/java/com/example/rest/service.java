package com.example.rest;

import com.example.rest.entity.Weather;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import tools.jackson.databind.JsonNode;
import tools.jackson.databind.ObjectMapper;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class service {
   public Weather fetch(String city){

      String key="ee11ed933f82352a8a5c0128284fea56";
      String url= "https://api.openweathermap.org/data/2.5/weather?q="
              + city + "&appid=" +key+ "&units=metric";

      RestTemplate restTemplate=new RestTemplate();
      String json=restTemplate.getForObject(url, String.class);

      ObjectMapper mapper= new ObjectMapper();
      JsonNode root= mapper.readTree(json);

      double temp= root.path("main").path("temp").asDouble();
      int humidity=root.path("main").path("humidity").asInt();
      String description = root.path("weather").get(0).path("description").asText();
      Weather weather= new Weather();

      weather.setCity(city);
      weather.setTemperature(temp);
      weather.setHumidity(humidity);
      weather.setDescription(description);
      weather.setCreatedAt(LocalDateTime.now());

      return weather;
   }


   }

