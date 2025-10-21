package com.example.estrategias;

import java.util.List;

import com.example.Contexto;

public class AvaliacaoForca implements AvaliacaoEstrategia{
    
    @Override
    public Contexto avaliar(List<Teste> testes, Contexto contexto){
        for (Teste teste : testes) {
            component.avaliar(contexto);
        }
        return contexto;
    }
}
