package com.example.estrategias;

import java.util.List;

import com.example.Contexto;
import com.example.testes.Teste;

public interface AvaliacaoEstrategia {
    
    Contexto avaliar(List<Teste> testes, Contexto contexto);
}
