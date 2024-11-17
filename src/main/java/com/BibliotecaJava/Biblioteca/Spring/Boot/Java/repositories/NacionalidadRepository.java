package com.BibliotecaJava.Biblioteca.Spring.Boot.Java.repositories;

import com.BibliotecaJava.Biblioteca.Spring.Boot.Java.domain.entities.NacionalidadEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NacionalidadRepository extends CrudRepository<NacionalidadEntity, Long> {
}
