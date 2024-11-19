package com.BibliotecaJava.Biblioteca.Spring.Boot.Java.controllers;
import com.BibliotecaJava.Biblioteca.Spring.Boot.Java.domain.entities.AutorEntity;
import com.BibliotecaJava.Biblioteca.Spring.Boot.Java.domain.entities.NacionalidadEntity;
import com.BibliotecaJava.Biblioteca.Spring.Boot.Java.service.AutorService;
import com.BibliotecaJava.Biblioteca.Spring.Boot.Java.service.NacionalidadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;
import java.util.List;
import java.util.Optional;

@RequestMapping("/api/nacionalidades")
@RestController
public class NacionalidadController {

    private final NacionalidadService nacionalidadService;

    @Autowired
    public NacionalidadController(NacionalidadService nacionalidadService) {
        this.nacionalidadService = nacionalidadService;
    }

    @GetMapping("/all")
    public List<NacionalidadEntity> getAllNacionalidad() {
        return nacionalidadService.getAllNacionalidades();
    }

    @GetMapping("/{id}")
    public Optional<NacionalidadEntity> getNacionalidadById(@PathVariable Long id) {
        return nacionalidadService.getNacionalidadById(id);
    }

    @PostMapping
    public NacionalidadEntity createNacionalidad(@RequestBody NacionalidadEntity nacionalidadEntity) {
        return nacionalidadService.createNacionalidad(nacionalidadEntity);
    }

    @PutMapping("/{id}")
    public Optional<NacionalidadEntity> updateNacionalidad(@PathVariable Long id, @RequestBody NacionalidadEntity nacionalidadEntity) {
        return nacionalidadService.updateNacionalidad(id, nacionalidadEntity);
    }

    @DeleteMapping("/{id}")
    public Optional<String> deleteNacionalidad(@PathVariable Long id) {
        return nacionalidadService.deleteNacionalidad(id);
    }
}
