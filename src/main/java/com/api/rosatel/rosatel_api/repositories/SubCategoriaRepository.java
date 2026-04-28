package com.api.rosatel.rosatel_api.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.api.rosatel.rosatel_api.models.SubCategoria;

@Repository
public interface SubCategoriaRepository extends JpaRepository<SubCategoria, Integer> {
    
}
