package com.api.rosatel.rosatel_api.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.rosatel.rosatel_api.models.SubCategoria;
import com.api.rosatel.rosatel_api.repositories.SubCategoriaRepository;

@Service
public class SubCategoriaService {
    @Autowired
    private SubCategoriaRepository subCategoriaRepository;
    
    public List<SubCategoria> getSubCategoriaRepository() {
        return subCategoriaRepository.findAll();
    }
}
