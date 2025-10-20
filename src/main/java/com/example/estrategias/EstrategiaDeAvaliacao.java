package com.example.estrategias;

import java.util.List;

import com.example.Component;
import com.example.Contexto;

public interface EstrategiaDeAvaliacao {
    
    Contexto avaliar(List<Component> components, Contexto contexto);
}
