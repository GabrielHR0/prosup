package com.example.avaliadores;


import java.util.ArrayList;
import java.util.List;

import com.example.Component;
import com.example.Contexto;
import com.example.estrategias.AvaliacaoEstrategia;

public class Avaliador implements Component {

    private AvaliacaoEstrategia estrategia;
    private final List<Component> children = new ArrayList<>();
    
    public Avaliador(AvaliacaoEstrategia estrategia){
        this.estrategia = estrategia;
    }

    @Override
    public Contexto avaliar(Contexto contexto){
        return estrategia.avaliar(this.children, contexto);
    }
    
    public void add(Component child){
        this.children.add(child);
    }

    public void remove(Component child){
        this.children.remove(child);
    }

    public AvaliacaoEstrategia getEstrategia() {
        return estrategia;
    }

    public Avaliador setEstrategia(AvaliacaoEstrategia estrategia) {
        this.estrategia = estrategia;
        return this;
    }
}


