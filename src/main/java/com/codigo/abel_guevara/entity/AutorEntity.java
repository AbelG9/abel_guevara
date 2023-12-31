package com.codigo.abel_guevara.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import javax.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
@Table(name = "autor")
public class AutorEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;

    private Integer estado;

    @ManyToMany(mappedBy = "autores")
    @JsonIgnore
    private Set<LibroEntity> libroEntitySet = new HashSet<>();
}
