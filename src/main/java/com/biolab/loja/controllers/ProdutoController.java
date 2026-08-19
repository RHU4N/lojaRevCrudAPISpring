package com.biolab.loja.controllers;

import com.biolab.loja.DTOs.ProdutoReq;
import com.biolab.loja.services.ProdutoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.ExampleObject;
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
    //Define o que ai ta escrito no campo do swagger
    @Operation(
            summary = "Cadastrar produto",
            description = "Cadastra um novo produto na loja"
    )
    //define exemplo do swagger
    @io.swagger.v3.oas.annotations.parameters.RequestBody(
            description = "Cadastre seu produto",
            required = true,
            content = @Content(
                    mediaType = "application/json",
                    examples = @ExampleObject(
                            name = "Produto exemplo",
                            value = """
                        {
                            "nome": "Notebook Acer Nitro V15",
                            "descricao": "Notebook para desenvolvimento",
                            "preco": 3500.00,
                            "estoque": 10,
                            "categoria": "ELETRONICOS"
                        }
                        """
                    )
            )
    )
    public ResponseEntity<?> cadastrarProd(@Valid @RequestBody ProdutoReq produto){
        //Retorno statu8s 201 com a criação do prod
        return ResponseEntity.status(HttpStatus.CREATED).body(produtoService.criarProd(produto));
    }

    //metodo get
    @GetMapping
    @Operation(
            summary = "Listar todos os produtos",
            description = "Liste todos os produtos na loja"
    )
    public ResponseEntity<?> listarProdutos(){
        //retorno status 200 com lista dos produtos
        return ResponseEntity.status(HttpStatus.OK).body(produtoService.listarProdutos());
    }

    //metodo get especifio para id
    @GetMapping("/{id}")
    @Operation(
            summary = "Listando produto por ID",
            description = "Liste um produto especifico com base no id"
    )
    public ResponseEntity<?> buscarProduto(@PathVariable Long id){
        ////retorno status 200 com prod especifico o id
        return ResponseEntity.ok().body(produtoService.buscarID(id));
    }

    //mtodo delete
    @DeleteMapping("/{id}")
    @Operation(
            summary = "Delete m produto",
            description = "Delete um produto com base no id"
    )
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
    @Operation(
            summary = "Atualize um produto",
            description = "Atualize os dados de um produto com base no id"
    )
    @io.swagger.v3.oas.annotations.parameters.RequestBody(
            description = "Atualize seu produto",
            required = true,
            content = @Content(
                    mediaType = "application/json",
                    examples = @ExampleObject(
                            name = "Produto exemplo",
                            value = """
                        {
                            "nome": "Notebook Acer Nitro V15 ryzen 7",
                            "descricao": "Notebook para desenvolvimento",
                            "preco": 3500.00,
                            "estoque": 10,
                            "categoria": "ELETRONICOS"
                        }
                        """
                    )
            )
    )
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
