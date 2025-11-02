package com.example.estrategias;

import java.util.List;

import com.example.Biometria;

public interface AvaliacaoEstrategia<T> {
    
    Object avaliar(List<T> testes, Biometria biometria);
}
