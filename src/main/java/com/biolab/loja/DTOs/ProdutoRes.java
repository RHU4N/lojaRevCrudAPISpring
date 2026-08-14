package com.biolab.loja.DTOs;

import com.biolab.loja.entities.Categoria;
import com.biolab.loja.entities.Produtos;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.NotNull;

//DTO de response
public class ProdutoRes {

    //variaveis da classe que serão mostradas nas resposats
    private long id;
    private String nome;
    private String descricao;
    private double preco;
    private int estoque;
    private Categoria categoria;


    //construtores
    public ProdutoRes(long id, String nome, String descricao, double preco, int estoque, Categoria categoria) {
        this.id = id;
        this.nome = nome;
        this.descricao = descricao;
        this.preco = preco;
        this.estoque = estoque;
        this.categoria = categoria;
    }

    public ProdutoRes() {
    }

    public ProdutoRes(String nome, String descricao, double preco, int estoque, Categoria categoria) {
        this.nome = nome;
        this.descricao = descricao;
        this.preco = preco;
        this.estoque = estoque;
        this.categoria = categoria;
    }

    //construtor especifico puxando classe não DTO
    public ProdutoRes(Produtos produto) {
        id = produto.getId();
        nome = produto.getNome();
        descricao = produto.getDescricao();
        preco = produto.getPreco();
        estoque = produto.getEstoque();
        categoria = produto.getCategoria();
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
