package com.ejemplo.jpa_tutorial.service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

import com.ejemplo.jpa_tutorial.models.Producto;

public interface ProductoService {

    List<Producto> findALL();
    Optional<Producto> findById(Long id);
    List<Producto> findByNombre(String nombre);
    List<Producto> findByPrecioRange(BigDecimal minPrecio, BigDecimal maxPrecio);

}
