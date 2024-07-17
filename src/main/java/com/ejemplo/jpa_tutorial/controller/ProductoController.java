package com.ejemplo.jpa_tutorial.controller;

import java.math.BigDecimal;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ejemplo.jpa_tutorial.models.Producto;
import com.ejemplo.jpa_tutorial.service.ProductoService;

@RestController
@RequestMapping
public class ProductoController {

    @Autowired
    private ProductoService productoService;

    @GetMapping("/api/productos")
    public List<Producto> findAll() {
        return productoService.findALL();
    }

    @GetMapping("/api/productos/{id}")
    public Producto findById(@PathVariable Long id) {
        return productoService.findById(id).orElse(null);
    }

    @GetMapping("/api/productos/query")
    public List<Producto> queryProductos(@RequestParam Map<String, String> params) {
        if (params.containsKey("nombre")) {
            String nombre = params.get("nombre");
            return productoService.findByNombre(nombre);
        } else if (params.containsKey("preciomin") && params.containsKey("preciomax")) {
            BigDecimal preciomin = new BigDecimal(params.get("preciomin"));
            BigDecimal preciomax = new BigDecimal(params.get("preciomax"));
            return productoService.findByPrecioRange(preciomin, preciomax);
        } else {
            return Collections.emptyList();
        }
    }

}
