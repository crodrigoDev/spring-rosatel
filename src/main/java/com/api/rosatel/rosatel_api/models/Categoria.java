package com.api.rosatel.rosatel_api.models;
import java.util.List;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "categoria")
public class Categoria {
    @Id
    private Integer id;
    @Column(name = "detalle", nullable = false)
    private String detalle;

    
    @OneToMany(mappedBy = "categoria")
    private List<SubCategoria> subCategorias;

    
    @OneToMany(mappedBy = "categoria")
    private List<Producto> productos;
}
