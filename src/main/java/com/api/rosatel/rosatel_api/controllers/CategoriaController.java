package com.api.rosatel.rosatel_api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.api.rosatel.rosatel_api.models.ApiResponse;
import com.api.rosatel.rosatel_api.models.Categoria;
import com.api.rosatel.rosatel_api.services.CategoriaService;

@RestController
@RequestMapping("/api/rosatel/categorias")
public class CategoriaController {
    @Autowired
    private CategoriaService categoriaService;

    @GetMapping
    public ResponseEntity<ApiResponse<List<Categoria>>> getCategorias() {
        List<Categoria> categorias = categoriaService.getCategoriaRepository();
        ApiResponse<List<Categoria>> response = new ApiResponse<List<Categoria>>(
                "success",
                "Categorias obtenidas exitosamente",
                categorias);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<Categoria>> getCategoriaById(@PathVariable Integer id) {
        Categoria categoria = categoriaService.getCategoriaById(id);
        ApiResponse<Categoria> response = new ApiResponse<Categoria>(
                "success",
                "Categoria obtenida exitosamente",
                categoria);
        return ResponseEntity.ok(response);
    }
}
