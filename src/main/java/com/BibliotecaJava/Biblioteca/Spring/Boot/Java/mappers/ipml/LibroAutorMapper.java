package com.BibliotecaJava.Biblioteca.Spring.Boot.Java.mappers.ipml;

import com.BibliotecaJava.Biblioteca.Spring.Boot.Java.domain.dto.LibroAutorDto;
import com.BibliotecaJava.Biblioteca.Spring.Boot.Java.domain.dto.LibroDto;
import com.BibliotecaJava.Biblioteca.Spring.Boot.Java.domain.entities.LibroAutorEntity;
import com.BibliotecaJava.Biblioteca.Spring.Boot.Java.domain.entities.LibroEntity;
import com.BibliotecaJava.Biblioteca.Spring.Boot.Java.mappers.Mapper;
import org.springframework.stereotype.Component;
import org.modelmapper.ModelMapper;

@Component
public class LibroAutorMapper implements Mapper<LibroAutorEntity, LibroAutorDto> {
    private final ModelMapper modelMapper;

    public LibroAutorMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    @Override
    public LibroAutorDto mapTo(LibroAutorEntity libroAutorEntity) {
        return modelMapper.map(libroAutorEntity, LibroAutorDto.class);
    }

    @Override
    public LibroAutorEntity mapFrom(LibroAutorDto libroAutorDto) {
        return modelMapper.map(libroAutorDto, LibroAutorEntity.class);
    }
}
