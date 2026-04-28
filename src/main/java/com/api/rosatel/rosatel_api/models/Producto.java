package com.api.rosatel.rosatel_api.models;
import java.util.List;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "producto")
public class Producto {
    @Id
    private Integer id;
    @Column(name = "nombre", nullable = false)
    private String nombre;
    @Column(name = "descripcion", nullable = false)
    private String descripcion;
    @Column(name = "precio", nullable = false, columnDefinition = "DECIMAL(10,2)")
    private Double precio;
    @Column(name = "stock", nullable = false)
    private int stock;

    @ManyToOne
    @JoinColumn(name = "idCategoria")
    private Categoria categoria;

    @ManyToOne
    @JoinColumn(name = "idSubCategoria")
    private SubCategoria subCategoria;

    @ManyToMany
    @JoinTable(
        name = "producto_color",
        joinColumns = @JoinColumn(name = "idProducto"),
        inverseJoinColumns = @JoinColumn(name = "idColor")
    )
    private List<Color> colores;
}
