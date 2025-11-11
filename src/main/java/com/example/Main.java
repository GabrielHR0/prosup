package com.example;

import com.example.avaliadores.Avaliador;
import com.example.estrategias.AvaliacaoForca;
import com.example.factory.TesteDeForcaFactory;
import com.example.testes.TesteDeForca;


public class Main {
    public static void main(String[] args) {
        // Estratégia de avaliação
        Avaliador avaliacao = new Avaliador(new AvaliacaoForca());

        // Cria os testes via fábrica
        TesteDeForca supino = TesteDeForcaFactory.criarSupino();
        TesteDeForca terra = TesteDeForcaFactory.criarLevantamentoTerra();
        TesteDeForca agachamento = TesteDeForcaFactory.criarAgachamento();
        TesteDeForca puxada = TesteDeForcaFactory.criarPuxada();

        // Define entradas
        supino.setEntrada(100.0);
        terra.setEntrada(150.0);
        agachamento.setEntrada(120.0);
        puxada.setEntrada(12.0);

        // Biometria
        Biometria aluno = new Biometria(30, 1.76, 100.0, com.example.enums.Sexo.MASCULINO);

        // Adiciona testes à avaliação
        avaliacao.add(supino);
        avaliacao.add(terra);
        avaliacao.add(agachamento);
        avaliacao.add(puxada);

        // Avaliação final
        Object resultado = avaliacao.avaliar(aluno);
        System.out.println("Resultado da Avaliação de Força: " + resultado);
    }
}