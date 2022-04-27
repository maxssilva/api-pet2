package com.resumo.spring.resumospringapi.controller;

import com.resumo.spring.resumospringapi.model.Cliente;
import com.resumo.spring.resumospringapi.repository.ClienteRepository;
import com.resumo.spring.resumospringapi.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/clientes")
public class ClienteController {

    @Autowired
    private ClienteRepository clienteRepository;
    @Autowired
    private ClienteService clienteService;

    @GetMapping
    public List<Cliente> listar(){
       return clienteRepository.findAll();
    }
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Cliente adicionar(@Valid @RequestBody Cliente cliente) {
        return clienteService.salvarCliente(cliente);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Cliente> atualizar_cliente(@Valid @PathVariable Long id, @RequestBody Cliente cliente ){
        if (!clienteRepository.existsById(id)){
            return ResponseEntity.notFound().build();
        }
        cliente.setIdCliente(id);
        cliente = clienteService.salvarCliente(cliente);
        return ResponseEntity.ok(cliente);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Cliente> deleta_cliente(@PathVariable Long id){
        if (!clienteRepository.existsById(id)){
            return ResponseEntity.notFound().build();
        }
        clienteService.deletarClientePeloId(id);
        return ResponseEntity.noContent().build();
    }



}
