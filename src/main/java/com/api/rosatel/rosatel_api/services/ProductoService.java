package com.api.rosatel.rosatel_api.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.rosatel.rosatel_api.models.Producto;
import com.api.rosatel.rosatel_api.repositories.ProductoRepository;

@Service
public class ProductoService {
    @Autowired
    private ProductoRepository productoRepository;

    public List<Producto> getProductoRepository() {
        return productoRepository.findAll();
    }

    public Producto getProductoById(Integer id) {
        return productoRepository.findById(id).orElse(null);
    }

    public List<Producto> getProductosBySubCategoria(Integer idSubCategoria) {
        return productoRepository.findByIdSubCategoria(idSubCategoria);
    }

    public List<Producto> getProductosByCategoria(Integer idCategoria) {
        return productoRepository.findBySubCategoria_IdCategoria(idCategoria);
    }
}
