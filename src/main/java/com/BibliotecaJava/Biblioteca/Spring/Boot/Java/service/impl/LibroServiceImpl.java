package com.BibliotecaJava.Biblioteca.Spring.Boot.Java.service.impl;

import com.BibliotecaJava.Biblioteca.Spring.Boot.Java.domain.entities.LibroEntity;
import com.BibliotecaJava.Biblioteca.Spring.Boot.Java.repositories.LibroRepository;
import com.BibliotecaJava.Biblioteca.Spring.Boot.Java.service.LibroService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LibroServiceImpl implements LibroService {
    private final LibroRepository libroRepository;

    public LibroServiceImpl(LibroRepository libroRepository) {
        this.libroRepository = libroRepository;
    }

    @Override
    public LibroEntity createLibro(LibroEntity libro) {
        return libroRepository.save(libro);
    }

    @Override
    public Optional<LibroEntity> getLibroById(Long id) {
        return libroRepository.findById(id);

    }

    @Override
    public List<LibroEntity> getAllLibros() {
        return (List<LibroEntity>) libroRepository.findAll();

    }

    @Override
    public Optional<LibroEntity> updateLibro(Long id, LibroEntity libro) {
        return libroRepository.findById(id).map(existingLibro -> {
            libro.setId(existingLibro.getId());
            return libroRepository.save(libro);
        });
    }

    @Override
    public Optional<String> deleteLibro(Long id) {
        return libroRepository.findById(id).map(libro -> {
            libroRepository.deleteById(id);
            return "Libro eliminado";
        });
    }
}
