package com.senai.biblioteca.controller;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.senai.biblioteca.dto.LivroRequest;
import com.senai.biblioteca.dto.LivroResponse;
import com.senai.biblioteca.mapper.LivroMapper;
import com.senai.biblioteca.model.Livro;
import com.senai.biblioteca.service.LivroService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("livros")
public class LivroController {
    
    @Autowired
    private LivroService service;

    @Autowired
    private LivroMapper mapper;


    @GetMapping
    public ResponseEntity<List<LivroResponse>> listar() {
        List<Livro> livros = service.consultar();
        List<LivroResponse> resp = new ArrayList<>();
        for (var livro : livros) {
            LivroResponse livroDTO = mapper.toResponse(livro);
            resp.add(livroDTO);
        }
        // loop em versao usando stream (funcional)
        // var resp = livros.stream().map(livro -> livroDTO = mapper.toResponse(livro)).toList();
        return ResponseEntity.ok().body(resp);
    }

    @GetMapping("{isbn}")
    public ResponseEntity<LivroResponse> consultar(@PathVariable String isbn) {
        Livro livro = service.consultar(isbn);
        // substituido pelo MapStruct, que funciona para mapear inclusive com records
        // LivroResponse resp = new LivroResponse(livro.getIsbn(), livro.getTitulo(), livro.getNomeAutor(), 
        //     livro.getQtdPaginas(), livro.getDataPublicacao(), livro.getDisponivel()); 
        LivroResponse resp = mapper.toResponse(livro);
        return ResponseEntity.ok().body(resp);
    }

    @PostMapping
    public ResponseEntity<LivroResponse> cadastrar(@RequestBody @Valid LivroRequest request) {
        // Livro livro = new Livro(request.isbn(), request.titulo(), request.nomeAutor(), 
        //     request.qtdPaginas(), request.dataPublicacao());
        // Conversao usando MapStruct:
        Livro livro = mapper.toEntity(request);
        livro = service.criar(livro);
        // LivroResponse resp = new LivroResponse(livro.getIsbn(), livro.getTitulo(), livro.getNomeAutor(), 
            // livro.getQtdPaginas(), livro.getDataPublicacao(), livro.getDisponivel()); 
        LivroResponse resp = mapper.toResponse(livro);
        return ResponseEntity.created(URI.create(resp.isbn())).body(resp);
    }

}
