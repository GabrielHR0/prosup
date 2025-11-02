package com.example.avaliadores;


import java.util.ArrayList;
import java.util.List;

import com.example.Biometria;
import com.example.estrategias.AvaliacaoEstrategia;
import com.example.testes.Teste;

public class Avaliador {

    private AvaliacaoEstrategia estrategia;
    private final List<Teste> testes = new ArrayList<>();
    
    public Avaliador(AvaliacaoEstrategia estrategia){
        this.estrategia = estrategia;
    }

    public Object avaliar(Biometria biometria){
        return estrategia.avaliar(this.testes, biometria);
    }
    
    public void add(Teste child){
        this.testes.add(child);
    }

    public void remove(Teste child){
        this.testes.remove(child);
    }

    public AvaliacaoEstrategia getEstrategia() {
        return estrategia;
    }

    public Avaliador setEstrategia(AvaliacaoEstrategia estrategia) {
        this.estrategia = estrategia;
        return this;
    }
}


