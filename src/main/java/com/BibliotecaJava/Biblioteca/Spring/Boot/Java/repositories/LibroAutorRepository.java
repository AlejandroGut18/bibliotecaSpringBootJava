package com.BibliotecaJava.Biblioteca.Spring.Boot.Java.repositories;

import com.BibliotecaJava.Biblioteca.Spring.Boot.Java.domain.entities.LibroAutorEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LibroAutorRepository extends CrudRepository<LibroAutorEntity, Long> {
}
