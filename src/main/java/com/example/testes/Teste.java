package com.example.testes;

import com.example.enums.Unidade;

public abstract class Teste {
    protected String nome;
    protected Unidade unidade;

    public Teste(String nome, Unidade unidade) {
        this.nome = nome;
        this.unidade = unidade;
    }
}
