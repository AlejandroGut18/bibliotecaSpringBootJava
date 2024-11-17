package com.BibliotecaJava.Biblioteca.Spring.Boot.Java.repositories;

import com.BibliotecaJava.Biblioteca.Spring.Boot.Java.domain.entities.LibroEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LibroRepository extends CrudRepository<LibroEntity, Long> {
}
