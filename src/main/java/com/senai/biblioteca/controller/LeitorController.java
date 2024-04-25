package com.senai.biblioteca.controller;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.senai.biblioteca.service.LeitorService;

import jakarta.validation.Valid;

import com.senai.biblioteca.dto.LeitorRequest;
import com.senai.biblioteca.dto.LeitorResponse;
import com.senai.biblioteca.mapper.LeitorMapper;
import com.senai.biblioteca.model.Leitor;

@RestController
@RequestMapping("leitores")
public class LeitorController {
    
    @Autowired
    private LeitorService service;

    @Autowired
    private LeitorMapper mapper;


    @GetMapping
    public ResponseEntity<List<LeitorResponse>> listar() {
        List<Leitor> leitores = service.consultar();
        // List<LeitorResponse> resp = leitores.stream().map(leitor -> mapper.toResponse(leitor)).toList();
        List<LeitorResponse> resp = leitores.stream().map(mapper::toResponse).toList();
        return ResponseEntity.ok().body(resp);
    }

    @GetMapping("{cpf}")
    public ResponseEntity<LeitorResponse> consultarPeloCpf(@PathVariable Long cpf) {
        var leitor = service.consultar(cpf);
        var resp = mapper.toResponse(leitor);
        return ResponseEntity.ok().body(resp);
    }

    @PostMapping
    public ResponseEntity<LeitorResponse> cadastrar(@RequestBody @Valid LeitorRequest request) {
        var leitor = mapper.toEntity(request);
        service.inserir(leitor);
        var leitorResp = mapper.toResponse(leitor);
        return ResponseEntity.created(URI.create(leitor.getCpf().toString())).body(leitorResp);
    }

}
