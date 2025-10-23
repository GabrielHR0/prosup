package com.example;

import com.example.avaliadores.Avaliador;
import com.example.enums.Equipamento;
import com.example.enums.Genero;
import com.example.enums.Unidade;
import com.example.estrategias.AvaliacaoForca;
import com.example.testes.TesteDeForca;

public class Main {
    public static void main(String[] args) {
        Avaliador avaliacao1 = new Avaliador(new AvaliacaoForca());

        TesteDeForca testeSupino = new TesteDeForca("supino", Unidade.KG, Equipamento.BARRA);
        TesteDeForca testeTerra = new TesteDeForca("levantamento_terra", Unidade.KG, Equipamento.BARRA);
        TesteDeForca testeAgachamento = new TesteDeForca("agachamento", Unidade.KG, Equipamento.BARRA);
        TesteDeForca puxada = new TesteDeForca("supino", Unidade.REPETICAO, Equipamento.BARRA_FIXA);
        
        testeSupino.setEntrada(100.0);
        testeTerra.setEntrada(100.0);
        testeAgachamento.setEntrada(100.0);
        puxada.setEntrada(100.0);

        Biometria biometriaAluno1 = new Biometria(30, 1.76, 80.2, Genero.MASCULINO);

        

    }
}