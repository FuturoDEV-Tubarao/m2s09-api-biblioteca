package com.senai.biblioteca.dto;

import java.time.LocalDate;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;

public record LivroRequest(
        @NotEmpty(message = "Campo obrigatório") 
        String isbn,
        
        @NotEmpty(message = "Campo obrigatório") 
        @Size(min=1, max = 100, message = "Tamanho inválido") 
        String titulo,
        
        @NotEmpty(message = "Campo obrigatório") 
        @Size(min=3, max = 100, message = "Tamanho inválido")
        String nomeAutor,

        @NotNull(message = "Campo obrigatório") 
        @Positive(message = "Deve ser nro positivo") 
        Integer qtdPaginas,
        
        @NotNull(message = "Campo obrigatório") 
        @Past(message = "Deve ser uma data anterior à atual") 
        LocalDate dataPublicacao
) {
    
}
