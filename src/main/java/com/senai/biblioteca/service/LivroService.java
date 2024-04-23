package com.senai.biblioteca.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.senai.biblioteca.exception.RegistroExistenteException;
import com.senai.biblioteca.exception.RegistroNaoEncontradoException;
import com.senai.biblioteca.model.Livro;
import com.senai.biblioteca.repository.LivroRepository;

@Service
public class LivroService {

    @Autowired
    private LivroRepository livroRepository;

    public List<Livro> consultar() {
        return livroRepository.findAll();
    }

    public Livro consultar(String isbn) {
        return livroRepository.findById(isbn)
            .orElseThrow(() -> new RegistroNaoEncontradoException());
    }

    public Livro criar(Livro livro) {
        boolean existe = livroRepository.existsById(livro.getIsbn());
        if (existe)
            throw new RegistroExistenteException();
        livro = livroRepository.save(livro);
        return livro;
    }
    
}
