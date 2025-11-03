package com.example;

import com.example.avaliadores.Avaliador;
import com.example.enums.Equipamento;
import com.example.enums.Sexo;
import com.example.enums.Unidade;
import com.example.estrategias.AvaliacaoForca;
import com.example.tabelas_classificacao.ClassificacaoEquipamento;
import com.example.tabelas_classificacao.ClassificacaoSexo;
import com.example.tabelas_classificacao.Nivel;
import com.example.tabelas_classificacao.TabelaClassificacao;
import com.example.testes.TesteDeForca;
import com.example.testes.TesteForcaAgachamento;
import com.example.testes.TesteForcaPuxada;
import com.example.testes.TesteForcaSupino;
import com.example.testes.TesteForcaTerra;

public class Main {
    public static void main(String[] args) {
        // Estratégia de avaliação
        Avaliador avaliacao1 = new Avaliador(new AvaliacaoForca());

        // ---------------- SUPINO ----------------

        //Barra
        TabelaClassificacao tabelaClassificacaoSupino = new TabelaClassificacao();
        ClassificacaoEquipamento barraSupino = new ClassificacaoEquipamento(Equipamento.BARRA);
        tabelaClassificacaoSupino.add(barraSupino);

        ClassificacaoSexo supinoMasc = new ClassificacaoSexo(Sexo.MASCULINO);
        ClassificacaoSexo supinoFem = new ClassificacaoSexo(Sexo.FEMININO);
        barraSupino.add(supinoMasc);
        barraSupino.add(supinoFem);

        supinoMasc.add(new Nivel("Iniciante", 1.0, 0.0, 60.0));
        supinoMasc.add(new Nivel("Intermediário", 2.0, 60.0, 100.0));
        supinoMasc.add(new Nivel("Avançado", 3.0, 100.0, 120.0));
        supinoMasc.add(new Nivel("Altamente Avançado", 4.0, 120.0, null));

        supinoFem.add(new Nivel("Iniciante", 1.0, 0.0, 40.0));
        supinoFem.add(new Nivel("Intermediário", 2.0, 40.0, 70.0));
        supinoFem.add(new Nivel("Avançado", 3.0, 70.0, 90.0));
        supinoFem.add(new Nivel("Altamente Avançado", 4.0, 90.0, null));

        //Halter
        ClassificacaoEquipamento halterSupino = new ClassificacaoEquipamento(Equipamento.HALTER);
        tabelaClassificacaoSupino.add(halterSupino);

        ClassificacaoSexo supinoHalterMasc = new ClassificacaoSexo(Sexo.MASCULINO);
        ClassificacaoSexo supinoHalterFem = new ClassificacaoSexo(Sexo.FEMININO);
        halterSupino.add(supinoHalterMasc);
        halterSupino.add(supinoHalterFem);

        supinoHalterMasc.add(new Nivel("Iniciante", 1.0, 0.0, 80.0));
        supinoHalterMasc.add(new Nivel("Intermediário", 2.0, 60.0, 110.0));
        supinoHalterMasc.add(new Nivel("Avançado", 3.0, 100.0, 130.0));
        supinoHalterMasc.add(new Nivel("Altamente Avançado", 4.0, 150.0, null));

        supinoHalterFem.add(new Nivel("Iniciante", 1.0, 0.0, 40.0));
        supinoHalterFem.add(new Nivel("Intermediário", 2.0, 40.0, 70.0));
        supinoHalterFem.add(new Nivel("Avançado", 3.0, 70.0, 90.0));
        supinoHalterFem.add(new Nivel("Altamente Avançado", 4.0, 90.0, null));

        TesteDeForca testeSupino = new TesteForcaSupino("supino", Unidade.KG, Equipamento.BARRA, tabelaClassificacaoSupino);

        // ---------------- LEVANTAMENTO TERRA ----------------
        TabelaClassificacao tabelaClassificacaoTerra = new TabelaClassificacao();
        ClassificacaoEquipamento barraTerra = new ClassificacaoEquipamento(Equipamento.BARRA);
        tabelaClassificacaoTerra.add(barraTerra);

        ClassificacaoSexo terraMasc = new ClassificacaoSexo(Sexo.MASCULINO);
        ClassificacaoSexo terraFem = new ClassificacaoSexo(Sexo.FEMININO);
        barraTerra.add(terraMasc);
        barraTerra.add(terraFem);

        terraMasc.add(new Nivel("Iniciante", 1.0, 0.0, 100.0));
        terraMasc.add(new Nivel("Intermediário", 2.0, 100.0, 160.0));
        terraMasc.add(new Nivel("Avançado", 3.0, 160.0, 200.0));
        terraMasc.add(new Nivel("Altamente Avançado", 4.0, 200.0, null));

        terraFem.add(new Nivel("Iniciante", 1.0, 0.0, 60.0));
        terraFem.add(new Nivel("Intermediário", 2.0, 60.0, 100.0));
        terraFem.add(new Nivel("Avançado", 3.0, 100.0, 130.0));
        terraFem.add(new Nivel("Altamente Avançado", 4.0, 130.0, null));

        TesteDeForca testeTerra = new TesteForcaTerra("levantamento_terra", Unidade.KG, Equipamento.BARRA, tabelaClassificacaoTerra);

        // ---------------- AGACHAMENTO ----------------
        TabelaClassificacao tabelaClassificacaoAgachamento = new TabelaClassificacao();
        ClassificacaoEquipamento barraAgachamento = new ClassificacaoEquipamento(Equipamento.BARRA);
        tabelaClassificacaoAgachamento.add(barraAgachamento);

        ClassificacaoSexo agachaMasc = new ClassificacaoSexo(Sexo.MASCULINO);
        ClassificacaoSexo agachaFem = new ClassificacaoSexo(Sexo.FEMININO);
        barraAgachamento.add(agachaMasc);
        barraAgachamento.add(agachaFem);

        agachaMasc.add(new Nivel("Iniciante", 1.0, 0.0, 80.0));
        agachaMasc.add(new Nivel("Intermediário", 2.0, 80.0, 140.0));
        agachaMasc.add(new Nivel("Avançado", 3.0, 140.0, 180.0));
        agachaMasc.add(new Nivel("Altamente Avançado", 4.0, 180.0, null));

        agachaFem.add(new Nivel("Iniciante", 1.0, 0.0, 50.0));
        agachaFem.add(new Nivel("Intermediário", 2.0, 50.0, 90.0));
        agachaFem.add(new Nivel("Avançado", 3.0, 90.0, 120.0));
        agachaFem.add(new Nivel("Altamente Avançado", 4.0, 120.0, null));

        TesteDeForca testeAgachamento = new TesteForcaAgachamento("agachamento", Unidade.KG, Equipamento.BARRA, tabelaClassificacaoAgachamento);

        // ---------------- PUXADA ----------------
        TabelaClassificacao tabelaClassificacaoPuxada = new TabelaClassificacao();
        ClassificacaoEquipamento barraPuxada = new ClassificacaoEquipamento(Equipamento.BARRA_FIXA);
        tabelaClassificacaoPuxada.add(barraPuxada);

        ClassificacaoSexo puxadaMasc = new ClassificacaoSexo(Sexo.MASCULINO);
        ClassificacaoSexo puxadaFem = new ClassificacaoSexo(Sexo.FEMININO);
        barraPuxada.add(puxadaMasc);
        barraPuxada.add(puxadaFem);

        puxadaMasc.add(new Nivel("Iniciante", 1.0, 0.0, 5.0));
        puxadaMasc.add(new Nivel("Intermediário", 2.0, 5.0, 10.0));
        puxadaMasc.add(new Nivel("Avançado", 3.0, 10.0, 15.0));
        puxadaMasc.add(new Nivel("Altamente Avançado", 4.0, 15.0, null));

        puxadaFem.add(new Nivel("Iniciante", 1.0, 0.0, 3.0));
        puxadaFem.add(new Nivel("Intermediário", 2.0, 3.0, 7.0));
        puxadaFem.add(new Nivel("Avançado", 3.0, 7.0, 10.0));
        puxadaFem.add(new Nivel("Altamente Avançado", 4.0, 10.0, null));

        TesteDeForca testePuxada = new TesteForcaPuxada("puxada", Unidade.REPETICAO, Equipamento.BARRA_FIXA, tabelaClassificacaoPuxada);

        // ---------------- ENTRADAS ----------------
        testeSupino.setEntrada(100.0);
        testeTerra.setEntrada(150.0);
        testeAgachamento.setEntrada(120.0);
        testePuxada.setEntrada(12.0);

        // ---------------- BIOMETRIA DO ALUNO ----------------
        Biometria biometriaAluno1 = new Biometria(30, 1.76, 80.2, Sexo.MASCULINO);

        // ---------------- ADICIONA TESTES ----------------
        avaliacao1.add(testeSupino);
        avaliacao1.add(testeTerra);
        avaliacao1.add(testeAgachamento);
        avaliacao1.add(testePuxada);

        // ---------------- AVALIAÇÃO FINAL ----------------
        Object resultado = avaliacao1.avaliar(biometriaAluno1);

        System.out.println("Resultado da Avaliação de forca: " + resultado);


    }
}
