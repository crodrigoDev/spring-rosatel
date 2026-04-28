package com.api.rosatel.rosatel_api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import com.api.rosatel.rosatel_api.models.SubCategoria;
import org.springframework.web.bind.annotation.RestController;

import com.api.rosatel.rosatel_api.services.SubCategoriaService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
@RequestMapping("/api/rosatel/subcategorias")
public class SubCategoriaController {
    @Autowired
    private SubCategoriaService subCategoriaService;

    @GetMapping
    public List<SubCategoria> getSubCategorias() {
        return subCategoriaService.getSubCategoriaRepository();
    }
}
