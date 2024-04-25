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
    private LivroRepository repository;

    public List<Livro> consultar() {
        return repository.findAll();
    }

    public Livro consultar(String isbn) {
        return repository.findById(isbn)
            .orElseThrow(() -> new RegistroNaoEncontradoException());
    }

    public Livro criar(Livro livro) {
        boolean existe = repository.existsById(livro.getIsbn());
        if (existe)
            throw new RegistroExistenteException();
        livro = repository.save(livro);
        return livro;
    }

    public void emprestar(Livro livro) {
        livro.setDisponivel(false);
        repository.save(livro);
    }

    public void devolver(Livro livro) {
        livro.setDisponivel(true);
        repository.save(livro);
    }
    
}
