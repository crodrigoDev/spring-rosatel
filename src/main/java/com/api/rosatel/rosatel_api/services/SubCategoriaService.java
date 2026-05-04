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

    public SubCategoria getSubCategoriaById(Integer id) {
        return subCategoriaRepository.findById(id).orElse(null);
    }

    public SubCategoria createSubCategoria(SubCategoria subCategoria) {
        return subCategoriaRepository.save(subCategoria);
    }

    public SubCategoria updateSubCategoria(Integer id, SubCategoria subCategoria) {
        subCategoria.setId(id);
        return subCategoriaRepository.save(subCategoria);
    }
}
