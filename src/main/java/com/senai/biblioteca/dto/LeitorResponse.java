package com.senai.biblioteca.dto;

import java.time.LocalDate;

public record LeitorResponse(
    Long cpf,
    String nome,
    LocalDate dataNascimento) {
}
