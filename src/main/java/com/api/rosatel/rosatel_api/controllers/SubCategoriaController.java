package com.api.rosatel.rosatel_api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.api.rosatel.rosatel_api.models.ApiResponse;
import com.api.rosatel.rosatel_api.models.SubCategoria;
import com.api.rosatel.rosatel_api.services.SubCategoriaService;


@RestController
@RequestMapping("/api/rosatel/subcategorias")
public class SubCategoriaController {
    @Autowired
    private SubCategoriaService subCategoriaService;

    @GetMapping
    public ResponseEntity<ApiResponse<List<SubCategoria>>> getSubCategorias() {
        List<SubCategoria> subCategorias = subCategoriaService.getSubCategoriaRepository();
        ApiResponse<List<SubCategoria>> response = new ApiResponse<List<SubCategoria>>(
                "success",
                "Subcategorias obtenidas exitosamente",
                subCategorias);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<SubCategoria>> getSubCategoriaById(@PathVariable Integer id) {
        SubCategoria subCategoria = subCategoriaService.getSubCategoriaById(id);
        ApiResponse<SubCategoria> response = new ApiResponse<SubCategoria>(
                "success",
                "Subcategoria obtenida exitosamente",
                subCategoria);
        return ResponseEntity.ok(response);
    }
}
