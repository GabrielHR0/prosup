package com.example;

import com.example.enums.Sexo;

public class Biometria {
    
    private Integer idade;
    private Double altura;
    private Double massa;
    private Sexo sexo;

    public Biometria(Integer idade, Double altura, Double massa, Sexo sexo ) {
        this.idade = idade;
        this.altura = altura;
        this.massa = massa;
        this.sexo = sexo;
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

    public Sexo getSexo() {
        return sexo;
    }

    public void setSexo(Sexo sexo) {
        this.sexo = sexo;
    }




}
