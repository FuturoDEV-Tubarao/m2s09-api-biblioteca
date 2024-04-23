package com.senai.biblioteca.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.senai.biblioteca.model.Livro;

@Repository
public interface LivroRepository extends JpaRepository<Livro, String> {
    
}
