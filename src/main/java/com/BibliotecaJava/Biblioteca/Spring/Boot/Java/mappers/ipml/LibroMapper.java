package com.BibliotecaJava.Biblioteca.Spring.Boot.Java.mappers.ipml;

import com.BibliotecaJava.Biblioteca.Spring.Boot.Java.domain.dto.LibroDto;
import com.BibliotecaJava.Biblioteca.Spring.Boot.Java.domain.entities.LibroEntity;
import com.BibliotecaJava.Biblioteca.Spring.Boot.Java.mappers.Mapper;
import org.springframework.stereotype.Component;
import com.lorem.store.mappers.Mapper;
import org.modelmapper.ModelMapper;

@Component
public class LibroMapper implements Mapper<LibroEntity, LibroDto> {
    private final ModelMapper modelMapper;

    public LibroMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    @Override
    public LibroDto mapTo(LibroEntity libro) {
        return modelMapper.map(libro, LibroDto.class);
    }

    @Override
    public LibroEntity mapFrom(LibroDto libroDTO) {
        return modelMapper.map(libroDTO, LibroEntity.class);
    }
}
