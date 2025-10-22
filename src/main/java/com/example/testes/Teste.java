package com.example.testes;

import com.example.enums.Unidade;

public abstract class Teste {
    protected String nome;
    protected Unidade unidade;

    public Teste(String nome, Unidade unidade) {
        this.nome = nome;
        this.unidade = unidade;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Unidade getUnidade() {
        return unidade;
    }

    public void setUnidade(Unidade unidade) {
        this.unidade = unidade;
    }

}
