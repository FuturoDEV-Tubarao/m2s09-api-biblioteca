package com.senai.biblioteca.dto;

import java.time.LocalDate;

public record EmprestimoResponse(
    Integer id,
    LocalDate dataEmprestimo,
    LocalDate dataDevolucaoPrevista,
    LivroEmprestimoResponse livro,
    LeitorEmprestimoResponse leitor,
    boolean devolvido
) {
    
}
