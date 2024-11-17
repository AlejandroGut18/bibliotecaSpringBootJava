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
@Table(name = "libro")
public class LibroEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "libro_id_seq")

    private Long id;

    private String titulo;

    private String isbn;

    @OneToMany(mappedBy = "libro")
    private Set<LibroAutorEntity> libroAutores;

}
