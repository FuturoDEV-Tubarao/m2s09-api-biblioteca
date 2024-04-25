package com.senai.biblioteca.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.senai.biblioteca.exception.RegistroExistenteException;
import com.senai.biblioteca.exception.RegistroNaoEncontradoException;
import com.senai.biblioteca.model.Leitor;
import com.senai.biblioteca.repository.LeitorRepository;

@Service
public class LeitorService {
    
    @Autowired
    private LeitorRepository repository;

    public List<Leitor> consultar() {
        return repository.findAll();
    }

    public void inserir(Leitor leitor) {
        var existe = repository.existsById(leitor.getCpf());
        if (existe)
            throw new RegistroExistenteException();
        repository.save(leitor);    
    }

    public Leitor consultar(Long cpf) {
        // return repository.findById(cpf)
        //     .orElseThrow(() -> new RegistroNaoEncontradoException());
        return repository.findById(cpf)
            .orElseThrow(RegistroNaoEncontradoException::new);
    }

}
