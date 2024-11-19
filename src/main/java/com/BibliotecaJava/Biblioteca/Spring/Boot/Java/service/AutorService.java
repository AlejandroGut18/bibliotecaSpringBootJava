package com.BibliotecaJava.Biblioteca.Spring.Boot.Java.service;

import com.BibliotecaJava.Biblioteca.Spring.Boot.Java.domain.entities.AutorEntity;

import java.util.List;
import java.util.Optional;

public interface AutorService {
    AutorEntity createAutor(AutorEntity autor);

    Optional<AutorEntity> getAutorById(Long id);

    List<AutorEntity> getAllAutores();

    Optional<AutorEntity> updateAutor(Long id, AutorEntity autor);

    Optional<String> deleteAutor(Long id);
}
