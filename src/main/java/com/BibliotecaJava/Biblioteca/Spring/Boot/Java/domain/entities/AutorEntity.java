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
@Table(name = "autor")
public class AutorEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "autor_id_seq")
    @SequenceGenerator(name = "autor_id_seq", sequenceName = "autor_id_seq", allocationSize = 1)

    private Long id;

    private String nombre;

    @ManyToOne
    @JoinColumn(name = "nacionalidad_id")
    private NacionalidadEntity nacionalidad;

    @OneToMany(mappedBy = "autor")
    private Set<LibroAutorEntity> libroAutores;
}
