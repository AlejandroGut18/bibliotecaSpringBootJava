package com.BibliotecaJava.Biblioteca.Spring.Boot.Java.domain.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "libro_autor")
public class LibroAutorEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "libro_autor_id_seq")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "libro_id")
    private LibroEntity libro;

    @ManyToOne
    @JoinColumn(name = "autor_id")
    private AutorEntity autor;

    private String rol;
}
