package com.senai.biblioteca.controller;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.senai.biblioteca.dto.EmprestimoRequest;
import com.senai.biblioteca.dto.EmprestimoResponse;
import com.senai.biblioteca.mapper.EmprestimoMapper;
import com.senai.biblioteca.service.EmprestimoService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("emprestimos")
public class EmprestimoController {
    
    @Autowired
    private EmprestimoService service;

    @Autowired
    private EmprestimoMapper mapper;


    @PostMapping
    public ResponseEntity<EmprestimoResponse> emprestar(@RequestBody @Valid EmprestimoRequest request) {
        var emprestimo = service.emprestar(request.isbn(), request.cpf());
        var emprestimoResp = mapper.toResponse(emprestimo);
        return ResponseEntity.created(URI.create(emprestimo.getId().toString())).body(emprestimoResp);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<?> devolver(@PathVariable Integer id) {
        service.devolver(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping
    public ResponseEntity<List<EmprestimoResponse>> listar() {
        var emprestimos = service.consultar();
        var resp = emprestimos.stream().map(mapper::toResponse).toList();
        return ResponseEntity.ok().body(resp);
    }

}
