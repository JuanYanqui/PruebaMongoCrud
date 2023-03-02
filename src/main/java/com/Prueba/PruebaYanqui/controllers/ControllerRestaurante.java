package com.Prueba.PruebaYanqui.controllers;

import com.Prueba.PruebaYanqui.models.Restaurante;
import com.Prueba.PruebaYanqui.services.RestauranteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/restaurante")
public class ControllerRestaurante {
    @Autowired
    RestauranteService restauranteService;

    @GetMapping("/listar")
    public ResponseEntity<List<Restaurante>> listarProductos() {
        return new ResponseEntity<>(restauranteService.findByAll(),
                HttpStatus.OK);
    }
    @PostMapping("/crear")
    public ResponseEntity<Restaurante> crearProducto(
            @RequestBody Restaurante p) {
        return new ResponseEntity<>(restauranteService.save(p),
                HttpStatus.CREATED);
    }

    @PutMapping("/actualizar/{id}")
    public ResponseEntity<Restaurante> actualizarProducto(@PathVariable Long id, @RequestBody Restaurante r) {
        Restaurante resta = restauranteService.findById(id);
        if (resta == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            try {
                resta.setNombre(r.getNombre());
                resta.setDireccion(r.getDireccion());
                resta.setCorreo(r.getCorreo());
                resta.setCarta(r.getCarta());
                resta.setTelefono(r.getTelefono());
                return new ResponseEntity<>(restauranteService.save(r), HttpStatus.OK);
            } catch (DataAccessException e) {
                return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }
    }

    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<Restaurante> eliminarProducto(@PathVariable Long id) {
        restauranteService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
