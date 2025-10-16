package com.example;

import java.util.HashMap;
import java.util.Map;

public class Contexto {
    
    private final Map<String, Object> dados = new HashMap<>();

    public void put(String chave, Object valor){
        dados.put(chave, valor);
    }

    public Object get(String chave){
        return dados.get(chave);
    }
    
}
