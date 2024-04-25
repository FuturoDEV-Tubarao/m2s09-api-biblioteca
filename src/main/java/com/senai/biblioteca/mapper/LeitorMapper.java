package com.senai.biblioteca.mapper;

import org.mapstruct.Mapper;

import com.senai.biblioteca.dto.LeitorRequest;
import com.senai.biblioteca.dto.LeitorResponse;
import com.senai.biblioteca.model.Leitor;

@Mapper(componentModel = "spring")
public interface LeitorMapper {
    
    LeitorResponse toResponse(Leitor entity);

    Leitor toEntity(LeitorRequest request);

}
