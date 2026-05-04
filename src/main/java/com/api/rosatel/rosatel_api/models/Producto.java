package com.api.rosatel.rosatel_api.models;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "producto")
public class Producto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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
    @JoinColumn(name = "idSubCategoria", insertable = false, updatable = false)
    @JsonBackReference("subcategoria-productos")
    private SubCategoria subCategoria;
    private Integer idSubCategoria;

    @ManyToMany
    @JoinTable(
        name = "producto_color",
        joinColumns = @JoinColumn(name = "idProducto"),
        inverseJoinColumns = @JoinColumn(name = "idColor")
    )
    @JsonIgnoreProperties("productos")
    private List<Color> colores;
}
