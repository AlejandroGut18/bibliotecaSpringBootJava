package com.BibliotecaJava.Biblioteca.Spring.Boot.Java.controllers;
import com.BibliotecaJava.Biblioteca.Spring.Boot.Java.domain.dto.LibroAutorDto;
import com.BibliotecaJava.Biblioteca.Spring.Boot.Java.domain.entities.AutorEntity;
import com.BibliotecaJava.Biblioteca.Spring.Boot.Java.domain.entities.LibroAutorEntity;
import com.BibliotecaJava.Biblioteca.Spring.Boot.Java.mappers.ipml.LibroAutorMapper;
import com.BibliotecaJava.Biblioteca.Spring.Boot.Java.service.LibroAutorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/libroAutores")
public class LibroAutorController {
    private final LibroAutorService libroAutorService;
    private final LibroAutorMapper libroAutorMapper;

    @Autowired
    public LibroAutorController(LibroAutorService libroAutorService, LibroAutorMapper libroAutorMapper) {
        this.libroAutorService = libroAutorService;
        this.libroAutorMapper = libroAutorMapper;
    }

    // Obtener todos los LibroAutor
    @GetMapping("/all")
    public List<LibroAutorDto> getAllLibroAutor() {
        return libroAutorService.getAllLibroAutores().stream()
                .map(libroAutorMapper::mapTo) // Convierte entidades a DTOs
                .collect(Collectors.toList());
    }

    // Obtener un LibroAutor por ID
    @GetMapping("/{id}")
    public LibroAutorDto getLibroAutorById(@PathVariable Long id) {
        return libroAutorService.getLibroAutorById(id)
                .map(libroAutorMapper::mapTo) // Convierte entidad a DTO
                .orElseThrow(() -> new RuntimeException("LibroAutor no encontrado"));
    }

    // Crear un LibroAutor
    @PostMapping
    public LibroAutorDto createLibroAutor(@RequestBody LibroAutorDto libroAutorDto) {
        LibroAutorEntity libroAutorEntity = libroAutorMapper.mapFrom(libroAutorDto); // Convierte DTO a entidad
        LibroAutorEntity createdLibroAutor = libroAutorService.createLibroAutor(libroAutorEntity);
        return libroAutorMapper.mapTo(createdLibroAutor); // Convierte entidad creada a DTO
    }

    // Actualizar un LibroAutor
    @PutMapping("/{id}")
    public LibroAutorDto updateLibroAutor(@PathVariable Long id, @RequestBody LibroAutorDto libroAutorDto) {
        LibroAutorEntity libroAutorEntity = libroAutorMapper.mapFrom(libroAutorDto); // Convierte DTO a entidad
        LibroAutorEntity updatedLibroAutor = libroAutorService.updateLibroAutor(id, libroAutorEntity)
                .orElseThrow(() -> new RuntimeException("Error al actualizar el LibroAutor"));
        return libroAutorMapper.mapTo(updatedLibroAutor); // Convierte entidad actualizada a DTO
    }

    // Eliminar un LibroAutor
    @DeleteMapping("/{id}")
    public String deleteLibroAutor(@PathVariable Long id) {
        return libroAutorService.deleteLibroAutor(id)
                .orElseThrow(() -> new RuntimeException("LibroAutor no encontrado para eliminar"));
    }
}
