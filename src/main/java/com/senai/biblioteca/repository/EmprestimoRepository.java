package com.senai.biblioteca.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.senai.biblioteca.model.Emprestimo;

public interface EmprestimoRepository extends JpaRepository<Emprestimo, Integer> {
    
}
