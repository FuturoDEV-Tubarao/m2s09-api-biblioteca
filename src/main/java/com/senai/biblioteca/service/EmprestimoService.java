package com.senai.biblioteca.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.senai.biblioteca.exception.LivroIndisponivelException;
import com.senai.biblioteca.exception.RegistroNaoEncontradoException;
import com.senai.biblioteca.model.Emprestimo;
import com.senai.biblioteca.repository.EmprestimoRepository;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

@Service
public class EmprestimoService {
    
    @Autowired
    private EmprestimoRepository repository;

    @Autowired
    private LivroService livroService;

    @Autowired
    private LeitorService leitorService;

    private final int diasEmprestimos = 30;


    public Emprestimo emprestar(String isbn, Long cpf) {
        var livro = livroService.consultar(isbn);
        if (!livro.isDisponivel())
            throw new LivroIndisponivelException();
        var leitor = leitorService.consultar(cpf);
        var emprestimo = new Emprestimo(LocalDate.now(), diasEmprestimos, livro, leitor);
        emprestimo = repository.save(emprestimo);
        livroService.emprestar(livro);
        return emprestimo;
    }


    public List<Emprestimo> consultar() {
        return repository.findAll();
    }


    public void devolver(Integer id) {
        var emprestimo = repository.findById(id).orElseThrow(RegistroNaoEncontradoException::new);
        emprestimo.setDataDevolucao(LocalDate.now());
        repository.save(emprestimo);
        livroService.devolver(emprestimo.getLivro());
    }

}
