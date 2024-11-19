package com.BibliotecaJava.Biblioteca.Spring.Boot.Java.service.impl;

import com.BibliotecaJava.Biblioteca.Spring.Boot.Java.domain.entities.LibroAutorEntity;
import com.BibliotecaJava.Biblioteca.Spring.Boot.Java.service.LibroAutorService;
import com.BibliotecaJava.Biblioteca.Spring.Boot.Java.repositories.LibroAutorRepository;

import org.springframework.stereotype.Service;

import java.io.OptionalDataException;
import java.util.List;
import java.util.Optional;

@Service
public class LibroAutorServiceImpl implements LibroAutorService {
    private final LibroAutorRepository libroAutorRepository;

    public LibroAutorServiceImpl(LibroAutorRepository libroAutorRepository) {
        this.libroAutorRepository = libroAutorRepository;
    }
    @Override
    public LibroAutorEntity createLibroAutor(LibroAutorEntity libroAutor) {
        return libroAutorRepository.save(libroAutor);
    }

    @Override
    public Optional<LibroAutorEntity> getLibroAutorById(Long id) {
        return libroAutorRepository.findById(id);

    }

    @Override
    public List<LibroAutorEntity> getAllLibroAutores() {
        return (List<LibroAutorEntity>) libroAutorRepository.findAll();
    }

    @Override
    public Optional<LibroAutorEntity> updateLibroAutor(Long id, LibroAutorEntity libroAutor) {
        return libroAutorRepository.findById(id).map(existingLibroAutor -> {
            libroAutor.setId(existingLibroAutor.getId());
            return libroAutorRepository.save(libroAutor);
        });
    }

    @Override
    public Optional<String> deleteLibroAutor(Long id) {
        return libroAutorRepository.findById(id).map(libroAutor -> {
            libroAutorRepository.deleteById(id);
            return "Relación Libro-Autor eliminada";
        });
    }
}
