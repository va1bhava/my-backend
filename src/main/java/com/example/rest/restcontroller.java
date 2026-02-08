package com.example.rest;

import com.example.rest.entity.Weather;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/weather")
public class restcontroller {

    private service service;
    @Autowired
    public restcontroller(service service){
        this.service=service;
    }
    @PostMapping("/{city}")
    public String save(@PathVariable String city) throws Exception{
        service.fetchandsave(city);
        return "weather saved succesful";
    }

    @GetMapping("/show/{city}")
    public List<Weather> show(@PathVariable String city){
        return service.weather(city);
    }
}
