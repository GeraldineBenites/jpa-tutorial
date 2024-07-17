package com.ejemplo.jpa_tutorial.repository;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ejemplo.jpa_tutorial.models.Producto;


@Repository
public interface ProductoRepository extends JpaRepository<Producto,Long>{
    List<Producto> findByNombreContainingIgnoreCase(String nombre);
    List<Producto> findByPrecioBetween(BigDecimal minPrecio, BigDecimal maxPrecio);
}
