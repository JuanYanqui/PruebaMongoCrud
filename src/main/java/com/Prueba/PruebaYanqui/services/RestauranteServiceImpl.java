package com.Prueba.PruebaYanqui.services;

import com.Prueba.PruebaYanqui.models.Restaurante;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;

public class RestauranteServiceImpl  extends GenericServiceImpl<Restaurante, Long> implements RestauranteService{

    @Autowired
    RestauranteService restauranteService;
    @Override
    public CrudRepository<Restaurante, Long> getDao() {
        return  restauranteService;
    }
}
