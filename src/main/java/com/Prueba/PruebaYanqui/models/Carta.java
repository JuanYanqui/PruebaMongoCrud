package com.Prueba.PruebaYanqui.models;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Data
@Document(collection = "Carta")
public class Carta {
    private String nombre;
    private String catagoria;
    private Integer cantidad;

    private List<Plato> ListaPlatos;

}
