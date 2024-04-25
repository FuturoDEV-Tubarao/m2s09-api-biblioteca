package com.senai.biblioteca.dto;

import java.time.LocalDate;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Size;

public record LeitorRequest(
    @NotNull(message = "Campo Obrigatório") 
    Long cpf, 
    
    @NotEmpty(message = "Campo Obrigatório") 
    @Size(min = 3, max = 100, message = "Nome inválido")
    String nome, 
    
    @NotNull(message = "Campo Obrigatório")
    @Past(message = "Data inválida")
    LocalDate dataNascimento
) {
    
}
