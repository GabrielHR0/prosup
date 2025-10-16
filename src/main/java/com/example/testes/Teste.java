package com.example.testes;

import com.example.Avaliavel;
import com.example.Contexto;
import com.example.enums.Unidade;

public abstract class Teste implements Avaliavel {

    protected String nome;
    protected Unidade unidade;
    
    @Override
    public abstract Object avaliar(Contexto contexto);
}
