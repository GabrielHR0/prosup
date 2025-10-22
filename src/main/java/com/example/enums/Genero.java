package com.example.enums;

public enum Genero {
    MASCULINO("masculino"),
    FEMININO("feminino");

    public final String toString;
    
    Genero(String toString) {
        this.toString = toString;
    }

    @Override
    public String toString() {
        return toString;
    }
}
