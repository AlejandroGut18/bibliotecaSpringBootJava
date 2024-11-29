package com.BibliotecaJava.Biblioteca.Spring.Boot.Java.domain.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "nacionalidad")
public class NacionalidadEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "nacionalidad_id_seq")
    @SequenceGenerator(name = "nacionalidad_id_seq", sequenceName = "nacionalidad_id_seq", allocationSize = 1)
    private Long id;

    private String nombre;

    @OneToMany(mappedBy = "nacionalidad", cascade = CascadeType.ALL)
    private Set<AutorEntity> autores;
}
