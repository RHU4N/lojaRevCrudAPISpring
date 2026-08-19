package com.biolab.loja.entities;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

//classe entidade
@Entity
public class Produtos {
    //definindo id e tipo de geração
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    //Define o que vai ta escrito no campo do swagger
    @Schema(
            description = "ID o prod",
            example = "1"
    )
    private long id;

    //variaveis e alidação not null
    @NotNull
    @Schema(
            description = "nome do produto",
            example = "Notebook Gamer"
    )
    private String nome;

    @NotNull
    @Schema(
            description = "Descrição do produto",
            example = "16gb ram 4050ti led rgb"
    )
    private String descricao;

    @NotNull
    @Schema(
            description = "Preço do produto",
            example = "450.99"

    )
    private double preco;

    @NotNull
    @Schema(
            description = "Quantidade em estoque",
            example = "10"
    )
    private int estoque;

    //variavel enum e especificação enum
    @Enumerated(EnumType.STRING)
    @Schema(
            description = "Categoria do produto(ENUM)",
            example="ELETRONICOS"
    )
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
