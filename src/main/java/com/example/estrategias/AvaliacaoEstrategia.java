package com.example.estrategias;

import java.util.List;

import com.example.Biometria;
import com.example.Contexto;

public interface AvaliacaoEstrategia<T> {
    
    Contexto avaliar(List<T> testes, Biometria biometria);
}
