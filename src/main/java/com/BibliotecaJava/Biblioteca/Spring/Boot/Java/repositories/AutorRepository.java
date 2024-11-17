package com.BibliotecaJava.Biblioteca.Spring.Boot.Java.repositories;

import com.BibliotecaJava.Biblioteca.Spring.Boot.Java.domain.entities.AutorEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AutorRepository extends CrudRepository<AutorEntity, Long> {
}
