package com.BibliotecaJava.Biblioteca.Spring.Boot.Java.mappers.ipml;

import com.BibliotecaJava.Biblioteca.Spring.Boot.Java.domain.dto.NacionalidadDto;
import com.BibliotecaJava.Biblioteca.Spring.Boot.Java.domain.entities.NacionalidadEntity;
import com.BibliotecaJava.Biblioteca.Spring.Boot.Java.mappers.Mapper;
import org.springframework.stereotype.Component;
import org.modelmapper.ModelMapper;

@Component
public class NacionalidadMapper implements Mapper<NacionalidadEntity, NacionalidadDto> {
    private final ModelMapper modelMapper;

    public NacionalidadMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    @Override
    public NacionalidadDto mapTo(NacionalidadEntity nacionalidad) {
        return modelMapper.map(nacionalidad, NacionalidadDto.class);
    }

    @Override
    public NacionalidadEntity mapFrom(NacionalidadDto nacionalidadDTO) {
        return modelMapper.map(nacionalidadDTO, NacionalidadEntity.class);
    }
}
