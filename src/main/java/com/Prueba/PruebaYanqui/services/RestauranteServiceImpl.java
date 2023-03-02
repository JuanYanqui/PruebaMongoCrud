package com.Prueba.PruebaYanqui.services;

import com.Prueba.PruebaYanqui.models.Restaurante;
import com.Prueba.PruebaYanqui.repositories.RepositoryRestaurante;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

@Service
public class RestauranteServiceImpl  extends GenericServiceImpl<Restaurante, Long> implements RestauranteService{

    @Autowired
    RepositoryRestaurante restauranteService;
    @Override
    public CrudRepository<Restaurante, Long> getDao() {
        return  restauranteService;
    }
}
