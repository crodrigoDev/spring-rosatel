package com.api.rosatel.rosatel_api.models;

import java.util.List;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "color")
public class Color {
    @Id
    private Integer id;
    @Column(name = "detalle", nullable = false)
    private String detalle;

    @ManyToMany(mappedBy = "colores")
    private List<Producto> productos;
}
