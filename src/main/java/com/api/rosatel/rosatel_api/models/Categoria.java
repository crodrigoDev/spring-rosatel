package com.api.rosatel.rosatel_api.models;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "categoria")
public class Categoria {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "detalle", nullable = false)
    private String detalle;

    @OneToMany(mappedBy = "categoria")
    @JsonIgnore
    private List<SubCategoria> subCategorias;
}
