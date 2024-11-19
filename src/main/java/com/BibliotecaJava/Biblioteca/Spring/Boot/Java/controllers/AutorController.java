package com.BibliotecaJava.Biblioteca.Spring.Boot.Java.controllers;

import com.BibliotecaJava.Biblioteca.Spring.Boot.Java.domain.entities.AutorEntity;
import com.BibliotecaJava.Biblioteca.Spring.Boot.Java.service.AutorService;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;


import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/autores")
public class AutorController {
    private final AutorService autorService;

    @Autowired
    public AutorController(AutorService autorService) {
        this.autorService = autorService;
    }

    @GetMapping("/all")
    public List<AutorEntity> getAllAutor() {
        return autorService.getAllAutores();
    }

    @GetMapping("/{id}")
    public Optional<AutorEntity> getAutorById(@PathVariable Long id) {
        return autorService.getAutorById(id);
    }

    @PostMapping
    public AutorEntity createAutor(@RequestBody AutorEntity autorEntity) {
        return autorService.createAutor(autorEntity);
    }

    @PutMapping("/{id}")
    public Optional<AutorEntity> updateAutor(@PathVariable Long id, @RequestBody AutorEntity autorEntity) {
        return autorService.updateAutor(id, autorEntity);
    }

    @DeleteMapping("/{id}")
    public Optional<String> deleteAutor(@PathVariable Long id) {
        return autorService.deleteAutor(id);
    }
}
