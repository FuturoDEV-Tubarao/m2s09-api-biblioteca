package com.senai.biblioteca.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.senai.biblioteca.dto.EmprestimoResponse;
import com.senai.biblioteca.model.Emprestimo;

@Mapper(componentModel = "spring")
public interface EmprestimoMapper {

    @Mapping(source = "livro.isbn", target = "livro.isbn")
    @Mapping(source = "livro.titulo", target = "livro.titulo")
    @Mapping(source = "leitor.cpf", target = "leitor.cpf")
    @Mapping(source = "leitor.nome", target = "leitor.nome")
    EmprestimoResponse toResponse(Emprestimo entity);
    
}
