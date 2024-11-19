package com.BibliotecaJava.Biblioteca.Spring.Boot.Java.controllers;
import com.BibliotecaJava.Biblioteca.Spring.Boot.Java.domain.entities.AutorEntity;
import com.BibliotecaJava.Biblioteca.Spring.Boot.Java.domain.entities.LibroAutorEntity;
import com.BibliotecaJava.Biblioteca.Spring.Boot.Java.service.LibroAutorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/libroAutores")
public class LibroAutorController {
    private final LibroAutorService libroAutorService;

    @Autowired
    public LibroAutorController(LibroAutorService libroAutorService) {
        this.libroAutorService = libroAutorService;
    }

    @GetMapping("/all")
    public List<LibroAutorEntity> getAllLibroAutor() {
        return libroAutorService.getAllLibroAutores();
    }

    @GetMapping("/{id}")
    public Optional<LibroAutorEntity> getLibroAutorById(@PathVariable Long id) {
        return libroAutorService.getLibroAutorById(id);
    }

    @PostMapping
    public LibroAutorEntity createLibroAutor(@RequestBody LibroAutorEntity libroAutorEntity) {
        return libroAutorService.createLibroAutor(libroAutorEntity);
    }

    @PutMapping("/{id}")
    public Optional<LibroAutorEntity> updateLibroAutor(@PathVariable Long id, @RequestBody LibroAutorEntity libroAutorEntity) {
        return libroAutorService.updateLibroAutor(id, libroAutorEntity);
    }

    @DeleteMapping("/{id}")
    public Optional<String> deleteLibroAutor(@PathVariable Long id) {
        return libroAutorService.deleteLibroAutor(id);
    }
}
