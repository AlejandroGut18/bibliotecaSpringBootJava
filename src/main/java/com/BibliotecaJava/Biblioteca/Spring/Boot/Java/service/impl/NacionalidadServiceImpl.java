package com.BibliotecaJava.Biblioteca.Spring.Boot.Java.service.impl;

import com.BibliotecaJava.Biblioteca.Spring.Boot.Java.domain.entities.NacionalidadEntity;
import com.BibliotecaJava.Biblioteca.Spring.Boot.Java.repositories.NacionalidadRepository;
import com.BibliotecaJava.Biblioteca.Spring.Boot.Java.service.NacionalidadService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class NacionalidadServiceImpl implements NacionalidadService {
    private final NacionalidadRepository nacionalidadRepository;

    public NacionalidadServiceImpl(NacionalidadRepository nacionalidadRepository) {
        this.nacionalidadRepository = nacionalidadRepository;
    }

    @Override
    public NacionalidadEntity createNacionalidad(NacionalidadEntity nacionalidad) {
        return nacionalidadRepository.save(nacionalidad);
    }

    @Override
    public Optional<NacionalidadEntity> getNacionalidadById(Long id) {
        return nacionalidadRepository.findById(id);
    }

    @Override
    public List<NacionalidadEntity> getAllNacionalidades() {
        return (List<NacionalidadEntity>) nacionalidadRepository.findAll();

    }

    @Override
    public Optional<NacionalidadEntity> updateNacionalidad(Long id, NacionalidadEntity nacionalidad) {
        return nacionalidadRepository.findById(id).map(existingNacionalidad -> {
            nacionalidad.setId(existingNacionalidad.getId());
            return nacionalidadRepository.save(nacionalidad);
        });
    }

    @Override
    public Optional<String> deleteNacionalidad(Long id) {
        return nacionalidadRepository.findById(id).map(nacionalidad -> {
            nacionalidadRepository.deleteById(id);
            return "Nacionalidad eliminada";
        });
    }
}
