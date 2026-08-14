package com.biolab.loja.services;

import com.biolab.loja.DTOs.ProdutoReq;
import com.biolab.loja.DTOs.ProdutoRes;
import com.biolab.loja.entities.Produtos;
import com.biolab.loja.repositories.ProdutoRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

//definindo service onde está as regras de negocio/logica
@Service
public class ProdutoService {

    //importando repository para utilizar funções da inversão de dependencia
    private final ProdutoRepository produtoRepository;

    public ProdutoService(ProdutoRepository produtoRepository) {
        this.produtoRepository = produtoRepository;
    }

    //Metodo Post sendo enviado DTO request
    public ProdutoReq criarProd(ProdutoReq req){
        //pegando dados
        Produtos produto = new Produtos();
        produto.setNome(req.getNome());
        produto.setDescricao(req.getDescricao());
        produto.setPreco(req.getPreco());
        produto.setEstoque(req.getEstoque());
        produto.setCategoria(req.getCategoria());
        //salvando no bd
        produtoRepository.save(produto);
        //retorna valor
        return req;
    }

    //metodo get, espera lista de DTO response pois é mais de um dado
    public List<ProdutoRes>  listarProdutos(){
        //cria lista do bd
        List<Produtos> produtos = produtoRepository.findAll();
        //cria lista pra converter para response
        List<ProdutoRes> produtosRes = new ArrayList<>();

        //foreach pra preencher list response
        for (Produtos produto : produtos) {
            ProdutoRes produtoRes = new ProdutoRes(produto);
            produtosRes.add(produtoRes);

        }
        //retorna lista response
        return produtosRes;
    }

    //get por id
    public ProdutoRes buscarID(long id){
        //Pega um dado que pode ou não exite OPTIOPNAl
        Optional<Produtos> produto = produtoRepository.findById(id);
        //definir varivel para armazenar o prod em response
        ProdutoRes prod = new ProdutoRes();
        //passando dados
        prod.setId(produto.get().getId());
        prod.setNome(produto.get().getNome());
        prod.setDescricao(produto.get().getDescricao());
        prod.setPreco(produto.get().getPreco());
        prod.setEstoque(produto.get().getEstoque());
        prod.setCategoria(produto.get().getCategoria());
        //retorno valor
        return prod;
    }

    //delete e retorna String
    public String deletarProduto(long id){
        //pega dado optinal(pode ou não existir)
        Optional<Produtos> produto = produtoRepository.findById(id);
        //verifica se existe
        if(produto.isEmpty()){
            //retorna que não tem
            return "Usuario não existe";
        }else {
            //se existir apaga e retorna que apagou
            produtoRepository.deleteById(id);
            return "Produto removido com sucesso";
        }
    }

    //put
    public ProdutoReq atualizarProduto(long id, ProdutoReq req){
        //pega dado optinal(pode ou não existir)
        Optional<Produtos> prod = produtoRepository.findById(id);
        //verifica se existe
        if(prod.isEmpty()){
            //retorna no terminal não encontrado
            IO.println("Usuario não encontrado");
            //retorna null para ser tratado no controller
            return null;
        }else  {
            //se existe pega os dados
            Produtos produtos = prod.get();
            produtos.setNome(req.getNome());
            produtos.setDescricao(req.getDescricao());
            produtos.setPreco(req.getPreco());
            produtos.setEstoque(req.getEstoque());
            produtos.setCategoria(req.getCategoria());
            //salva
            produtoRepository.save(produtos);
            //retorna valor
            return req;
        }
    }
}
