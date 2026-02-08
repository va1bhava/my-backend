package com.example.rest.DAO;
import com.example.rest.entity.Weather;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class daoimpl implements dao{

    private EntityManager em;
    @Autowired
    public daoimpl(EntityManager em){
        this.em=em;
    }
    @Transactional
    @Override
    public void save(Weather weather) {
        em.persist(weather);
    }

    @Transactional
    @Override
    public List<Weather>weather(String city){
        return em.createQuery("FROM Weather where city=:city",Weather.class).setParameter("city",city).getResultList();
    }
}
