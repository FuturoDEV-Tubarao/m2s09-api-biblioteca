package com.senai.biblioteca.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.senai.biblioteca.model.Leitor;

public interface LeitorRepository extends JpaRepository<Leitor, Long> {
    
}
