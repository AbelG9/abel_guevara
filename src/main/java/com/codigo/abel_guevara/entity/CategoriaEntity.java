package com.codigo.abel_guevara.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
@Table(name = "categoria")
public class CategoriaEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;

    private Integer estado;

    @ManyToMany(mappedBy = "categorias")
    @JsonIgnore
    private Set<LibroEntity> libroEntitySet = new HashSet<>();
}
