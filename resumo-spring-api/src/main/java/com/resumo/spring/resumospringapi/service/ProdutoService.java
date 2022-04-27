package com.resumo.spring.resumospringapi.service;

import com.resumo.spring.resumospringapi.model.Produto;
import com.resumo.spring.resumospringapi.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProdutoService {

    @Autowired
    private ProdutoRepository produtoRepository;

    public Produto salvarProduto(Produto produto){
        Produto produtoExistente = produtoRepository.findBynome(produto.getNome());
        if(produtoExistente!= null && produtoExistente.equals(produto)){
            throw new NegocioException(("já existe um produto cadastrado com esse nome."));
        }
        return produtoRepository.save(produto);
    }


}
