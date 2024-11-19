package com.BibliotecaJava.Biblioteca.Spring.Boot.Java.controllers;
import com.BibliotecaJava.Biblioteca.Spring.Boot.Java.domain.entities.AutorEntity;
import com.BibliotecaJava.Biblioteca.Spring.Boot.Java.domain.entities.LibroEntity;
import com.BibliotecaJava.Biblioteca.Spring.Boot.Java.service.LibroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/libros")
public class LibroController {
    private final LibroService libroService;

    @Autowired
    public LibroController(LibroService libroService) {
        this.libroService = libroService;
    }

    @GetMapping("/all")
    public List<LibroEntity> getAllLibro() {
        return libroService.getAllLibros();
    }

    @GetMapping("/{id}")
    public Optional<LibroEntity> getLibroById(@PathVariable Long id) {
        return libroService.getLibroById(id);
    }

    @PostMapping
    public LibroEntity createLibro(@RequestBody LibroEntity libroEntity) {
        return libroService.createLibro(libroEntity);
    }

    @PutMapping("/{id}")
    public Optional<LibroEntity> updateLibro(@PathVariable Long id, @RequestBody LibroEntity libroEntity) {
        return libroService.updateLibro(id, libroEntity);
    }

    @DeleteMapping("/{id}")
    public Optional<String> deleteLibro(@PathVariable Long id) {
        return libroService.deleteLibro(id);
    }
}
