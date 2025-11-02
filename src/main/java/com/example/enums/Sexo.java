package com.example.enums;

public enum Sexo {
    MASCULINO("masculino"),
    FEMININO("feminino");

    public final String toString;
    
    Sexo(String toString) {
        this.toString = toString;
    }

    @Override
    public String toString() {
        return toString;
    }
}
