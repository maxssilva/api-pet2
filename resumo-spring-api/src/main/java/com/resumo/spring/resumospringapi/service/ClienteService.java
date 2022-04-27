package com.resumo.spring.resumospringapi.service;

import com.resumo.spring.resumospringapi.model.Cliente;
import com.resumo.spring.resumospringapi.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import com.resumo.spring.resumospringapi.service.NegocioException;
import org.springframework.web.bind.annotation.DeleteMapping;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    public Cliente salvarCliente(Cliente cliente) {
     Cliente clienteExistente = clienteRepository.findBycpf(cliente.getCpf());
        if(clienteExistente != null && clienteExistente.equals(cliente)){
            throw new NegocioException("Já existe um cliente cadastrado com este e-mail.");
                }
        return clienteRepository.save(cliente);
    }

    public void deletarClientePeloId(Long id) {
        clienteRepository.deleteById(id);


    }
}
