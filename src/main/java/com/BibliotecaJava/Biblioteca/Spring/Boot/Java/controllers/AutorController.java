package com.BibliotecaJava.Biblioteca.Spring.Boot.Java.controllers;

import com.BibliotecaJava.Biblioteca.Spring.Boot.Java.domain.dto.AutorDto;
import com.BibliotecaJava.Biblioteca.Spring.Boot.Java.domain.entities.AutorEntity;
import com.BibliotecaJava.Biblioteca.Spring.Boot.Java.mappers.ipml.AutorMapper;
import com.BibliotecaJava.Biblioteca.Spring.Boot.Java.service.AutorService;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;


import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/autores")
public class AutorController {
    private final AutorService autorService;
    private final AutorMapper autorMapper;

    @Autowired
    public AutorController(AutorService autorService, AutorMapper autorMapper) {
        this.autorService = autorService;
        this.autorMapper = autorMapper;
    }

    @GetMapping("/all")
    public List<AutorDto> getAllAutor() {
        return autorService.getAllAutores().stream()
                .map(autorMapper::mapTo) // Usa el mapper para convertir las entidades a DTOs
                .collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public AutorDto getAutorById(@PathVariable Long id) {
        return autorService.getAutorById(id)
                .map(autorMapper::mapTo) // Convierte la entidad a DTO si se encuentra
                .orElseThrow(() -> new RuntimeException("Autor no encontrado")); // Manejo básico de errores
    }

    @PostMapping("/add")
    public AutorDto createAutor(@RequestBody AutorDto autorDto) {
        AutorEntity autorEntity = autorMapper.mapFrom(autorDto); // Convierte DTO a entidad
        AutorEntity createdAutor = autorService.createAutor(autorEntity);
        return autorMapper.mapTo(createdAutor); // Convierte la entidad creada a DTO
    }

    @PutMapping("/{id}")
    public AutorDto updateAutor(@PathVariable Long id, @RequestBody AutorDto autorDto) {
        AutorEntity autorEntity = autorMapper.mapFrom(autorDto); // Convierte DTO a entidad
        AutorEntity updatedAutor = autorService.updateAutor(id, autorEntity)
                .orElseThrow(() -> new RuntimeException("Error al actualizar el autor")); // Manejo básico de errores
        return autorMapper.mapTo(updatedAutor); // Convierte la entidad actualizada a DTO
    }

    @DeleteMapping("/{id}")
    public String deleteAutor(@PathVariable Long id) {
        return autorService.deleteAutor(id)
                .orElseThrow(() -> new RuntimeException("Autor no encontrado para eliminar")); // Manejo básico de errores
    }
}
