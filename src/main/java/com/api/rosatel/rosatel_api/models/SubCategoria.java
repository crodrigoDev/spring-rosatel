package com.api.rosatel.rosatel_api.models;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "subcategoria")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class SubCategoria {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "detalle", nullable = false)
    private String detalle;

    @OneToMany(mappedBy = "subCategoria")
    @JsonManagedReference
    private List<Producto> productos;

    @ManyToOne
    @JoinColumn(name = "idCategoria", insertable = false, updatable = false)
    @JsonBackReference
    private Categoria categoria;
    private Integer idCategoria;
}
