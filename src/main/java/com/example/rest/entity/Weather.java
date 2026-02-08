package com.example.rest.entity;
import jakarta.persistence.*;
import java.time.LocalDateTime;
import jakarta.persistence.Table;

@Entity
@Table(name="weather_info")
public class Weather {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name="city", unique = true)
    private String city;

    @Column(name="temp")
    private double temperature;

    @Column(name="humidity")
    private int humidity;

    @Column(name="description")
    private String description;

    @Column(name ="time")
    private LocalDateTime createdAt;

    public Weather() {
    }
    public void setId(int id) {
        this.id = id;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setTemperature(double temperature) {
        this.temperature = temperature;
    }

    public void setHumidity(int humidity) {
        this.humidity = humidity;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public String getCity() {
        return city;
    }

    public double getTemperature() {
        return temperature;
    }

    public int getHumidity() {
        return humidity;
    }

    public String getDescription() {
        return description;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public int getId() {
        return id;
    }


}
