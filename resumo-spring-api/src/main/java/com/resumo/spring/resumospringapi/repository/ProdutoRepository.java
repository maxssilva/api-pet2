package com.resumo.spring.resumospringapi.repository;

import com.resumo.spring.resumospringapi.model.Produto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Long> {

    Produto findBynome(String nome);
}
