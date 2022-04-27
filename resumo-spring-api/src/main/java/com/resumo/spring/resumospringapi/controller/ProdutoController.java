package com.resumo.spring.resumospringapi.controller;

import com.resumo.spring.resumospringapi.model.Produto;
import com.resumo.spring.resumospringapi.repository.ProdutoRepository;
import com.resumo.spring.resumospringapi.service.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/produtos")
public class ProdutoController {

    @Autowired
    private ProdutoRepository produtoRepository;

    @Autowired
    private ProdutoService produtoService;

    @GetMapping
    public List<Produto> listarProdutos(){
        return produtoRepository.findAll();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Produto adicionarProduto(@RequestBody Produto produto){
        return produtoService.salvarProduto(produto);
    }




}
