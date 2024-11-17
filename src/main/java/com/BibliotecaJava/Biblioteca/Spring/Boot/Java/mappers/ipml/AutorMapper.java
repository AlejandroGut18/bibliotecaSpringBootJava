package com.BibliotecaJava.Biblioteca.Spring.Boot.Java.mappers.ipml;

import com.BibliotecaJava.Biblioteca.Spring.Boot.Java.domain.dto.AutorDto;
import com.BibliotecaJava.Biblioteca.Spring.Boot.Java.domain.entities.AutorEntity;
import com.BibliotecaJava.Biblioteca.Spring.Boot.Java.mappers.Mapper;
import org.springframework.stereotype.Component;
import org.modelmapper.ModelMapper;

@Component
public class AutorMapper implements Mapper<AutorEntity, AutorDto> {
    private final ModelMapper modelMapper;

    public AutorMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    @Override
    public AutorDto mapTo(AutorEntity autor) {
        return modelMapper.map(autor, AutorDto.class);
    }

    @Override
    public AutorEntity mapFrom(AutorDto autorDTO) {
        return modelMapper.map(autorDTO, AutorEntity.class);
    }
}
