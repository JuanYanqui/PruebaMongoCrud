package com.Prueba.PruebaYanqui.repositories;

import com.Prueba.PruebaYanqui.models.Restaurante;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface RepositoryRestaurante  extends MongoRepository<Restaurante, Long> {
}
