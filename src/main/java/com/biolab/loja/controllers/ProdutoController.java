package com.biolab.loja.controllers;

import com.biolab.loja.DTOs.ProdutoReq;
import com.biolab.loja.services.ProdutoService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

//Annotation pra definir controller e rota
@RestController
@RequestMapping("/Prod")
public class ProdutoController {

    // importando service(regras do negocio/logica)
    private final ProdutoService produtoService;

    public ProdutoController(ProdutoService produtoService) {
        this.produtoService = produtoService;
    }

    //Criação do metodo Post
    @PostMapping
    public ResponseEntity<?> cadastrarProd(@Valid @RequestBody ProdutoReq produto){
        //Retorno statu8s 201 com a criação do prod
        return ResponseEntity.status(HttpStatus.CREATED).body(produtoService.criarProd(produto));
    }

    //metodo get
    @GetMapping
    public ResponseEntity<?> listarProdutos(){
        //retorno status 200 com lista dos produtos
        return ResponseEntity.status(HttpStatus.OK).body(produtoService.listarProdutos());
    }

    //metodo get especifio para id
    @GetMapping("/{id}")
    public ResponseEntity<?> buscarProduto(@PathVariable Long id){
        ////retorno status 200 com prod especifico o id
        return ResponseEntity.ok().body(produtoService.buscarID(id));
    }

    //mtodo delete
    @DeleteMapping("/{id}")
    public ResponseEntity<?> removerProduto(@PathVariable Long id){
        //verifica se existe
        if (produtoService.buscarID(id) == null){
            //retorna 404 pois não existe prod
            return ResponseEntity.notFound().build();
        }else {
            //deleta prod e retorna 200
            produtoService.deletarProduto(id);
            return ResponseEntity.ok().body("Produto removido com sucesso");
        }
    }

    //metodo put
    @PutMapping("/{id}")
    public ResponseEntity<?> atualizarProduto(@PathVariable Long id, @Valid @RequestBody ProdutoReq produto){
        //verifica se existe
        if (produtoService.buscarID(id) == null){
            //retorna 404 pois não existe prod
            return ResponseEntity.notFound().build();
        }else  {
            //altera e retorna 200 OK
            produtoService.atualizarProduto(id, produto);
            return ResponseEntity.ok().body("Produto atualizado com sucesso");
        }
    }
}
