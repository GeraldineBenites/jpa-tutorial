package com.ejemplo.jpa_tutorial.service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ejemplo.jpa_tutorial.models.Producto;
import com.ejemplo.jpa_tutorial.repository.ProductoRepository;

@Service
public class ProductoServiceImpl implements ProductoService{

    @Autowired
    private ProductoRepository repo;

    public ProductoServiceImpl(ProductoRepository repo) {
        this.repo = repo;
    }

    @Override
    public List<Producto> findALL() {
        return repo.findAll();
    }

    @Override
    public Optional<Producto> findById(Long id) {
        return repo.findById(id);
    }

    @Override
    public List<Producto> findByNombre(String nombre) {
        return repo.findByNombreContainingIgnoreCase(nombre);
    }

    @Override
    public List<Producto> findByPrecioRange(BigDecimal minPrecio, BigDecimal maxPrecio) {
        return repo.findByPrecioBetween(minPrecio, maxPrecio);
    }


}
