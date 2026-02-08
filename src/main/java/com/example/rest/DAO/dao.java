package com.example.rest.DAO;
import com.example.rest.entity.Weather;
import java.util.List;
public interface dao {
    public void save(Weather weather);
    public List<Weather> weather(String city);
}
