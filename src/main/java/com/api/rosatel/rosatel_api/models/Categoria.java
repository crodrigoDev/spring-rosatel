package com.api.rosatel.rosatel_api.models;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "categoria")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class Categoria {
    @Id
    private Integer id;
    @Column(name = "detalle", nullable = false)
    private String detalle;

    @OneToMany(mappedBy = "categoria")
    @JsonManagedReference
    private List<SubCategoria> subCategorias;
}
