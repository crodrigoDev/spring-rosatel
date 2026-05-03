package com.api.rosatel.rosatel_api.models;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "subcategoria")
public class SubCategoria {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "detalle", nullable = false)
    private String detalle;

    @OneToMany(mappedBy = "subCategoria")
    @JsonIgnore
    private List<Producto> productos;

    @ManyToOne
    @JoinColumn(name = "idCategoria", insertable = false, updatable = false)
    @JsonBackReference("categoria-subcategorias")
    private Categoria categoria;
    private Integer idCategoria;
}
