package com.BibliotecaJava.Biblioteca.Spring.Boot.Java.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class LibroAutorDto {
    private Long id;
    private LibroDto libro;
    private AutorDto autor;
    private String rol;
}
