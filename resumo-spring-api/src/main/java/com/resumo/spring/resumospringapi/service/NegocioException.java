package com.resumo.spring.resumospringapi.service;

public class NegocioException extends RuntimeException {
    private static final long serialVersionUID=1L;
    public NegocioException(String mensagem) {
        super(mensagem);
    }
}
