package com.api.rosatel.rosatel_api.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.api.rosatel.rosatel_api.models.Producto;

@Repository
public interface ProductoRepository extends JpaRepository<Producto, Long> {
    
}
