package com.example;

import com.example.enums.Genero;

public class Biometria {
    
    private Integer idade;
    private Double altura;
    private Double massa;
    private Genero genero;

    public Biometria(Integer idade, Double altura, Double massa, Genero genero) {
        this.idade = idade;
        this.altura = altura;
        this.massa = massa;
        this.genero = genero;
    }

    public Biometria() {
    }

    public Integer getIdade() {
        return idade;
    }

    public void setIdade(Integer idade) {
        this.idade = idade;
    }

    public Double getAltura() {
        return altura;
    }

    public void setAltura(Double altura) {
        this.altura = altura;
    }

    public Double getMassa() {
        return massa;
    }

    public void setMassa(Double massa) {
        this.massa = massa;
    }

    public Genero getGenero() {
        return genero;
    }

    public void setGenero(Genero genero) {
        this.genero = genero;
    }




}
