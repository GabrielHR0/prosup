package com.example.testes;

import com.example.enums.Equipamento;
import com.example.enums.Unidade;

public class TesteDeForca extends Teste {

    protected Double entrada;
    protected Equipamento equipamento;

    public TesteDeForca(String nome, Unidade unidade) {
        super(nome, unidade);
    }

    public Double getEntrada() {
        return entrada;
    }

    public void setEntrada(Double entrada) {
        this.entrada = entrada;
    }

    public Equipamento getEquipamento() {
        return equipamento;
    }

    public void setEquipamento(Equipamento equipamento) {
        this.equipamento = equipamento;
    }
}
