package com.example;

import com.example.avaliadores.Avaliador;
import com.example.enums.Equipamento;
import com.example.enums.Sexo;
import com.example.enums.Unidade;
import com.example.estrategias.AvaliacaoForca;
import com.example.tabelas_classificacao.ClassificacaoEquipamento;
import com.example.tabelas_classificacao.ClassificacaoSexo;
import com.example.tabelas_classificacao.Composite;
import com.example.tabelas_classificacao.Nivel;
import com.example.tabelas_classificacao.TabelaClassificacao;
import com.example.testes.TesteDeForca;
import com.example.testes.TesteForcaAgachamento;
import com.example.testes.TesteForcaPuxada;
import com.example.testes.TesteForcaSupino;
import com.example.testes.TesteForcaTerra;

public class Main {
    public static void main(String[] args) {
        Avaliador avaliacao1 = new Avaliador(new AvaliacaoForca());

        Composite tabelaClassificacaoSupino = new TabelaClassificacao();

        ClassificacaoEquipamento barraSupino = new ClassificacaoEquipamento();
        tabelaClassificacaoSupino.add(barraSupino);

        ClassificacaoSexo tabelaMasculina = new ClassificacaoSexo();
        ClassificacaoSexo tabelaFeminina = new ClassificacaoSexo();

        barraSupino.add(tabelaMasculina);
        barraSupino.add(tabelaFeminina);

        Nivel nivel1M = new Nivel("Iniciante", 1.0, 0.0);
        Nivel nivel2M = new Nivel("intermediário", 2.0, 60.0);
        Nivel nivel3M = new Nivel("Avançado", 3.0,     100.0);
        Nivel nivel4M = new Nivel("Altamente Avançado", 4.0, 120.0);

        tabelaMasculina.add(nivel1M);
        tabelaMasculina.add(nivel2M);
        tabelaMasculina.add(nivel3M);
        tabelaMasculina.add(nivel4M);

        Nivel nivel1F = new Nivel("Iniciante", 1.0, 0.0);
        Nivel nivel2F = new Nivel("intermediário", 2.0, 60.0);
        Nivel nivel3F = new Nivel("Avançado", 3.0,     80.0);
        Nivel nivel4F = new Nivel("Altamente Avançado", 4.0, 100.0);

        tabelaFeminina.add(nivel1F);
        tabelaFeminina.add(nivel2F);
        tabelaFeminina.add(nivel3F);
        tabelaFeminina.add(nivel4F);

        TesteDeForca testeSupino = new TesteForcaSupino("supino", Unidade.KG, Equipamento.BARRA, tabelaClassificacaoSupino);
        
        TesteDeForca testeTerra = new TesteForcaTerra("levantamento_terra", Unidade.KG, Equipamento.BARRA);
        TesteDeForca testeAgachamento = new TesteForcaAgachamento("agachamento", Unidade.KG, Equipamento.BARRA);
        TesteDeForca puxada = new TesteForcaPuxada("puxada", Unidade.REPETICAO, Equipamento.BARRA_FIXA);
        
        testeSupino.setEntrada(100.0);
        testeTerra.setEntrada(100.0);
        testeAgachamento.setEntrada(100.0);
        puxada.setEntrada(100.0);

        Biometria biometriaAluno1 = new Biometria(30, 1.76, 80.2, Sexo.MASCULINO);

        avaliacao1.add(testeSupino);
        avaliacao1.add(testeSupino);

        Object resposta = avaliacao1.avaliar(biometriaAluno1);

    }
}