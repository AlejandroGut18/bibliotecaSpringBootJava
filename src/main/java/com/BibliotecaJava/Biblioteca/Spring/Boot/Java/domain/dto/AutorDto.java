package com.BibliotecaJava.Biblioteca.Spring.Boot.Java.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AutorDto {
    private Long id;
    private String nombre;
    private NacionalidadDto nacionalidad;
}
