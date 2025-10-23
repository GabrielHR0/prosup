package com.example.enums;

public enum Equipamento {
    BARRA("barra"),
    HALTER("halter"),
    BARRA_FIXA("barra_fixa"),
    POLIA("polia");

    public final String toString;

    Equipamento(String toString) {
        this.toString = toString;
    }

    @Override
    public String toString() {
        return toString;
    }
}
