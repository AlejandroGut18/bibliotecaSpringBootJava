package com.BibliotecaJava.Biblioteca.Spring.Boot.Java.service;

import com.BibliotecaJava.Biblioteca.Spring.Boot.Java.domain.entities.LibroAutorEntity;

import java.io.OptionalDataException;
import java.util.List;
import java.util.Optional;

public interface LibroAutorService {
    LibroAutorEntity createLibroAutor(LibroAutorEntity libroAutor);

    Optional<LibroAutorEntity> getLibroAutorById(Long id);

    List<LibroAutorEntity> getAllLibroAutores();

    Optional<LibroAutorEntity> updateLibroAutor(Long id, LibroAutorEntity libroAutor);

    Optional<String> deleteLibroAutor(Long id);
}
