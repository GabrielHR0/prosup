package com.example.avaliadores;


import java.util.ArrayList;
import java.util.List;

import com.example.Component;
import com.example.Contexto;
import com.example.estrategias.EstrategiaDeAvaliacao;

public class Avaliador implements Component {

    private EstrategiaDeAvaliacao estrategia;
    private final List<Component> children = new ArrayList<>();
    
    @Override
    public Contexto avaliar(Contexto contexto){
        return estrategia.avaliar(this.children, contexto);
    }

    public EstrategiaDeAvaliacao getEstrategia() {
        return estrategia;
    }

    public void setEstrategia(EstrategiaDeAvaliacao estrategia) {
        this.estrategia = estrategia;
    }
}


