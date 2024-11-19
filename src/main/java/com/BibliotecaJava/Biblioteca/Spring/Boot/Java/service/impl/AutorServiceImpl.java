package com.BibliotecaJava.Biblioteca.Spring.Boot.Java.service.impl;

import com.BibliotecaJava.Biblioteca.Spring.Boot.Java.domain.entities.AutorEntity;
import com.BibliotecaJava.Biblioteca.Spring.Boot.Java.service.AutorService;
import com.BibliotecaJava.Biblioteca.Spring.Boot.Java.repositories.AutorRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class AutorServiceImpl implements AutorService {
    private final AutorRepository autorRepository;

    public AutorServiceImpl(AutorRepository autorRepository) {
        this.autorRepository = autorRepository;
    }

    @Override
    public AutorEntity createAutor(AutorEntity autor) {
        return autorRepository.save(autor);

    }

    @Override
    public Optional<AutorEntity> getAutorById(Long id) {
        return autorRepository.findById(id);
    }

    @Override
    public List<AutorEntity> getAllAutores() {
        return (List<AutorEntity>) autorRepository.findAll();
    }

    @Override
    public Optional<AutorEntity> updateAutor(Long id, AutorEntity autor) {
        return autorRepository.findById(id).map(existingAutor -> {
            autor.setId(existingAutor.getId());
            return autorRepository.save(autor);
        });    }

    @Override
    public Optional<String> deleteAutor(Long id) {
        return autorRepository.findById(id).map(autor -> {
            autorRepository.deleteById(id);
            return "Autor eliminado con éxito";
        });
    }
}
