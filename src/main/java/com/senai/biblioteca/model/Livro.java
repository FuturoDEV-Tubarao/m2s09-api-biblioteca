package com.senai.biblioteca.model;

import java.time.LocalDate;
import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "livros")
public class Livro {

    @Id
    private String isbn;

    private String titulo;

    private String nomeAutor;

    private Integer qtdPaginas;

    private LocalDate dataPublicacao;

    private Boolean disponivel;

    private LocalDateTime dataCadastro;


    public Livro() { }

    public Livro(String isbn, String titulo, String nomeAutor, Integer qtdPaginas, 
            LocalDate dataPublicacao) {
        this.isbn = isbn;
        this.titulo = titulo;
        this.nomeAutor = nomeAutor;
        this.qtdPaginas = qtdPaginas;
        this.dataPublicacao = dataPublicacao;
        this.disponivel = true;
        this.dataCadastro = LocalDateTime.now();
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getNomeAutor() {
        return nomeAutor;
    }

    public void setNomeAutor(String nomeAutor) {
        this.nomeAutor = nomeAutor;
    }

    public Integer getQtdPaginas() {
        return qtdPaginas;
    }

    public void setQtdPaginas(Integer qtdPaginas) {
        this.qtdPaginas = qtdPaginas;
    }

    public LocalDate getDataPublicacao() {
        return dataPublicacao;
    }

    public void setDataPublicacao(LocalDate dataPublicacao) {
        this.dataPublicacao = dataPublicacao;
    }

    public Boolean getDisponivel() {
        return disponivel;
    }

    public void setDisponivel(Boolean disponivel) {
        this.disponivel = disponivel;
    }

    public LocalDateTime getDataCadastro() {
        return dataCadastro;
    }

    public void setDataCadastro(LocalDateTime dataCadastro) {
        this.dataCadastro = dataCadastro;
    }
        
}
