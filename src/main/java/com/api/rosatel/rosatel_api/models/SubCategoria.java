package com.api.rosatel.rosatel_api.models;
import java.util.List;

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
    private List<Producto> productos;

    @ManyToOne
    @JoinColumn(name = "idCategoria")
    private Categoria categoria;
}
