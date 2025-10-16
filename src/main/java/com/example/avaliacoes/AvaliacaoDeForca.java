package com.example.avaliacoes;

import java.util.List;

import com.example.testes.Teste;

public class AvaliacaoDeForca extends  Avaliacao{
    
    public Object avaliar(List<Teste> testes){
        for (Teste teste : testes) {
            teste.avaliar();
        }
    }
}
