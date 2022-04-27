package com.resumo.spring.resumospringapi.repository;

import com.resumo.spring.resumospringapi.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long> {
    Cliente findBycpf(String cpf);

    }
