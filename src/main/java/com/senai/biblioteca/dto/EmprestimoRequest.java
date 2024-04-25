package com.senai.biblioteca.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

public record EmprestimoRequest(
    @NotEmpty(message = "Campo obrigatorio")
    String isbn,

    @NotNull(message = "Campo obrigatorio")
    Long cpf
) {
    
}
