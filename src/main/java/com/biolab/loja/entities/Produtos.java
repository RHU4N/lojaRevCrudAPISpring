package com.biolab.loja.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

//classe entidade
@Entity
public class Produtos {
    //definindo id e tipo de geração
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    //variaveis e alidação not null
    @NotNull
    private String nome;

    @NotNull
    private String descricao;

    @NotNull
    private double preco;

    @NotNull
    private int estoque;

    //variavel enum e especificação enum
    @Enumerated(EnumType.STRING)
    private Categoria categoria;

//construtores
    public Produtos(long id, String nome, String descricao, double preco, int estoque, Categoria categoria) {
        this.id = id;
        this.nome = nome;
        this.descricao = descricao;
        this.preco = preco;
        this.estoque = estoque;
        this.categoria = categoria;
    }


    public Produtos() {
    }

    public Produtos(String nome, String descricao, double preco, int estoque, Categoria categoria) {
        this.nome = nome;
        this.descricao = descricao;
        this.preco = preco;
        this.estoque = estoque;
        this.categoria = categoria;
    }

    //getters and setters
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public int getEstoque() {
        return estoque;
    }

    public void setEstoque(int estoque) {
        this.estoque = estoque;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }
}
