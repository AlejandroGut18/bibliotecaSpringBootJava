package com.BibliotecaJava.Biblioteca.Spring.Boot.Java.controllers;
import com.BibliotecaJava.Biblioteca.Spring.Boot.Java.domain.dto.NacionalidadDto;
import com.BibliotecaJava.Biblioteca.Spring.Boot.Java.domain.entities.NacionalidadEntity;
import com.BibliotecaJava.Biblioteca.Spring.Boot.Java.mappers.ipml.NacionalidadMapper;
import com.BibliotecaJava.Biblioteca.Spring.Boot.Java.service.NacionalidadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.stream.Collectors;

@RequestMapping("/api/nacionalidades")
@RestController
public class NacionalidadController {

    private final NacionalidadService nacionalidadService;
    private final NacionalidadMapper nacionalidadMapper;

    @Autowired
    public NacionalidadController(NacionalidadService nacionalidadService, NacionalidadMapper nacionalidadMapper) {
        this.nacionalidadService = nacionalidadService;
        this.nacionalidadMapper = nacionalidadMapper;
    }

    // Obtener todas las nacionalidades
    @GetMapping("/all")
    public List<NacionalidadDto> getAllNacionalidades() {
        return nacionalidadService.getAllNacionalidades().stream()
                .map(nacionalidadMapper::mapTo) // Convierte entidades a DTOs
                .collect(Collectors.toList());
    }

    // Obtener una nacionalidad por ID
    @GetMapping("/{id}")
    public NacionalidadDto getNacionalidadById(@PathVariable Long id) {
        return nacionalidadService.getNacionalidadById(id)
                .map(nacionalidadMapper::mapTo) // Convierte entidad a DTO
                .orElseThrow(() -> new RuntimeException("Nacionalidad no encontrada"));
    }

    // Crear una nacionalidad
    @PostMapping
    public NacionalidadDto createNacionalidad(@RequestBody NacionalidadDto nacionalidadDto) {
        NacionalidadEntity nacionalidadEntity = nacionalidadMapper.mapFrom(nacionalidadDto); // Convierte DTO a entidad
        NacionalidadEntity createdNacionalidad = nacionalidadService.createNacionalidad(nacionalidadEntity);
        return nacionalidadMapper.mapTo(createdNacionalidad); // Convierte entidad creada a DTO
    }

    // Actualizar una nacionalidad
    @PutMapping("/{id}")
    public NacionalidadDto updateNacionalidad(@PathVariable Long id, @RequestBody NacionalidadDto nacionalidadDto) {
        NacionalidadEntity nacionalidadEntity = nacionalidadMapper.mapFrom(nacionalidadDto); // Convierte DTO a entidad
        NacionalidadEntity updatedNacionalidad = nacionalidadService.updateNacionalidad(id, nacionalidadEntity)
                .orElseThrow(() -> new RuntimeException("Error al actualizar la nacionalidad"));
        return nacionalidadMapper.mapTo(updatedNacionalidad); // Convierte entidad actualizada a DTO
    }

    // Eliminar una nacionalidad
    @DeleteMapping("/{id}")
    public String deleteNacionalidad(@PathVariable Long id) {
        return nacionalidadService.deleteNacionalidad(id)
                .orElseThrow(() -> new RuntimeException("Nacionalidad no encontrada para eliminar"));
    }
}
