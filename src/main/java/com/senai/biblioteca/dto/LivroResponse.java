package com.senai.biblioteca.dto;

import java.time.LocalDate;

public record LivroResponse(   
        String isbn,
        String titulo,
        String nomeAutor,
        Integer qtdPaginas,
        LocalDate dataPublicacao,
        Boolean disponivel    
    ) { 
        
    };
