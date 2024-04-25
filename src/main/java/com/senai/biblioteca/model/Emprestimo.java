package com.senai.biblioteca.model;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "emprestimos")
public class Emprestimo {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private LocalDate dataEmprestimo;

    private Integer diasDeEmprestimo;

    private LocalDate dataDevolucao;

    @ManyToOne
    @JoinColumn(name="isbn", referencedColumnName = "isbn")
    private Livro livro;

    @ManyToOne
    @JoinColumn(name = "cpf", referencedColumnName = "cpf")
    private Leitor leitor;


    public Emprestimo() {
    }
    
    public Emprestimo(LocalDate dataEmprestimo, Integer diasDeEmprestimo, Livro livro, Leitor leitor) {
        this.dataEmprestimo = dataEmprestimo;
        this.diasDeEmprestimo = diasDeEmprestimo;
        this.livro = livro;
        this.leitor = leitor;
    }


    public LocalDate getDataDevolucaoPrevista() {
        return dataEmprestimo.plusDays(diasDeEmprestimo);
    }

    public boolean isDevolvido() {
        return dataDevolucao != null;
    }

    
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public LocalDate getDataEmprestimo() {
        return dataEmprestimo;
    }

    public void setDataEmprestimo(LocalDate dataEmprestimo) {
        this.dataEmprestimo = dataEmprestimo;
    }

    public Livro getLivro() {
        return livro;
    }

    public void setLivro(Livro livro) {
        this.livro = livro;
    }

    public Leitor getLeitor() {
        return leitor;
    }

    public void setLeitor(Leitor leitor) {
        this.leitor = leitor;
    }


    public Integer getDiasDeEmprestimo() {
        return diasDeEmprestimo;
    }


    public void setDiasDeEmprestimo(Integer diasDeEmprestimo) {
        this.diasDeEmprestimo = diasDeEmprestimo;
    }

    public LocalDate getDataDevolucao() {
        return dataDevolucao;
    }

    public void setDataDevolucao(LocalDate dataDevolucao) {
        this.dataDevolucao = dataDevolucao;
    }
    

}
