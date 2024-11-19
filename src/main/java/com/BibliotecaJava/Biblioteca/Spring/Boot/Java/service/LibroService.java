package com.BibliotecaJava.Biblioteca.Spring.Boot.Java.service;

import com.BibliotecaJava.Biblioteca.Spring.Boot.Java.domain.entities.LibroEntity;

import java.util.List;
import java.util.Optional;

public interface LibroService {
    LibroEntity createLibro(LibroEntity libro);

    Optional<LibroEntity> getLibroById(Long id);

    List<LibroEntity> getAllLibros();

    Optional<LibroEntity> updateLibro(Long id, LibroEntity libro);

    Optional<String> deleteLibro(Long id);
}
