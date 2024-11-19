package com.BibliotecaJava.Biblioteca.Spring.Boot.Java.service;

import com.BibliotecaJava.Biblioteca.Spring.Boot.Java.domain.entities.NacionalidadEntity;

import java.util.List;
import java.util.Optional;

public interface NacionalidadService {
    NacionalidadEntity createNacionalidad(NacionalidadEntity nacionalidad);

    Optional<NacionalidadEntity> getNacionalidadById(Long id);

    List<NacionalidadEntity> getAllNacionalidades();

    Optional<NacionalidadEntity> updateNacionalidad(Long id, NacionalidadEntity nacionalidad);

    Optional<String> deleteNacionalidad(Long id);
}
