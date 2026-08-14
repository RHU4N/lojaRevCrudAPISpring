package com.biolab.loja.DTOs;

import com.biolab.loja.entities.Categoria;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.NotNull;

//DTO para requisições não contem id
public class ProdutoReq {
    //variaeis e validações(db) da entidade

    @NotNull
    private String nome;

    @NotNull
    private String descricao;

    @NotNull
    private double preco;

    @NotNull
    private int estoque;

    @Enumerated(EnumType.STRING)
    private Categoria categoria;


    //construtores
    public ProdutoReq(String nome, String descricao, double preco, int estoque, Categoria categoria) {
        this.nome = nome;
        this.descricao = descricao;
        this.preco = preco;
        this.estoque = estoque;
        this.categoria = categoria;
    }


    public ProdutoReq() {
    }

    //getters and setters
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
