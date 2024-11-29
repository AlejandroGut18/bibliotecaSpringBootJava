package com.BibliotecaJava.Biblioteca.Spring.Boot.Java.controllers;
import com.BibliotecaJava.Biblioteca.Spring.Boot.Java.domain.dto.LibroDto;
import com.BibliotecaJava.Biblioteca.Spring.Boot.Java.domain.entities.LibroEntity;
import com.BibliotecaJava.Biblioteca.Spring.Boot.Java.mappers.ipml.LibroMapper;
import com.BibliotecaJava.Biblioteca.Spring.Boot.Java.service.LibroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/libros")
public class LibroController {
    private final LibroService libroService;
    private final LibroMapper libroMapper;

    @Autowired
    public LibroController(LibroService libroService, LibroMapper libroMapper) {
        this.libroService = libroService;
        this.libroMapper = libroMapper;
    }

    // Obtener todos los libros
    @GetMapping("/all")
    public List<LibroDto> getAllLibro() {
        return libroService.getAllLibros().stream()
                .map(libroMapper::mapTo) // Convierte entidades a DTOs
                .collect(Collectors.toList());
    }

    // Obtener un libro por ID
    @GetMapping("/{id}")
    public LibroDto getLibroById(@PathVariable Long id) {
        return libroService.getLibroById(id)
                .map(libroMapper::mapTo) // Convierte entidad a DTO
                .orElseThrow(() -> new RuntimeException("Libro no encontrado"));
    }

    @PostMapping
    public LibroDto createLibro(@RequestBody LibroDto libroDto) {
        LibroEntity libroEntity = libroMapper.mapFrom(libroDto); // Convierte DTO a entidad
        LibroEntity createdLibro = libroService.createLibro(libroEntity);
        return libroMapper.mapTo(createdLibro); // Convierte entidad creada a DTO
    }

    @PutMapping("/{id}")
    public LibroDto updateLibro(@PathVariable Long id, @RequestBody LibroDto libroDto) {
        LibroEntity libroEntity = libroMapper.mapFrom(libroDto); // Convierte DTO a entidad
        LibroEntity updatedLibro = libroService.updateLibro(id, libroEntity)
                .orElseThrow(() -> new RuntimeException("Error al actualizar el libro"));
        return libroMapper.mapTo(updatedLibro); // Convierte entidad actualizada a DTO
    }

    @DeleteMapping("/{id}")
    public String deleteLibro(@PathVariable Long id) {
        return libroService.deleteLibro(id)
                .orElseThrow(() -> new RuntimeException("Libro no encontrado para eliminar"));
    }
}
