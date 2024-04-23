package com.senai.biblioteca.mapper;

import org.mapstruct.Mapper;

import com.senai.biblioteca.dto.LivroRequest;
import com.senai.biblioteca.dto.LivroResponse;
import com.senai.biblioteca.model.Livro;

@Mapper(componentModel = "spring")
public interface LivroMapper {

    // LivroMapper INSTANCE = Mappers.getMapper(LivroMapper.class);

    LivroResponse toResponse(Livro entity);

    Livro toEntity(LivroRequest request);
    
}
