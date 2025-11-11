package com.example.factory;

import com.example.enums.Equipamento;
import com.example.enums.Sexo;
import com.example.enums.Unidade;
import com.example.tabelas_classificacao.ClassificacaoEquipamento;
import com.example.tabelas_classificacao.ClassificacaoSexo;
import com.example.tabelas_classificacao.Nivel;
import com.example.tabelas_classificacao.TabelaClassificacao;
import com.example.testes.TesteDeForca;
import com.example.testes.TesteForcaAgachamento;
import com.example.testes.TesteForcaPuxada;
import com.example.testes.TesteForcaSupino;
import com.example.testes.TesteForcaTerra;

public class TesteDeForcaFactory {

    public static TesteDeForca criarSupino() {
        TabelaClassificacao tabela = new TabelaClassificacao();
        ClassificacaoEquipamento barra = new ClassificacaoEquipamento(Equipamento.BARRA);
        tabela.add(barra);

        ClassificacaoSexo masc = new ClassificacaoSexo(Sexo.MASCULINO);
        ClassificacaoSexo fem = new ClassificacaoSexo(Sexo.FEMININO);
        barra.add(masc);
        barra.add(fem);

        masc.add(new Nivel("Iniciante", 1.0, 0.0, 60.0));
        masc.add(new Nivel("Intermediário", 2.0, 60.0, 100.0));
        masc.add(new Nivel("Avançado", 3.0, 100.0, 120.0));
        masc.add(new Nivel("Altamente Avançado", 4.0, 120.0, null));

        fem.add(new Nivel("Iniciante", 1.0, 0.0, 40.0));
        fem.add(new Nivel("Intermediário", 2.0, 40.0, 70.0));
        fem.add(new Nivel("Avançado", 3.0, 70.0, 90.0));
        fem.add(new Nivel("Altamente Avançado", 4.0, 90.0, null));

        return new TesteForcaSupino("supino", Unidade.KG, Equipamento.BARRA, tabela);
    }

    public static TesteDeForca criarLevantamentoTerra() {
        TabelaClassificacao tabela = new TabelaClassificacao();
        ClassificacaoEquipamento barra = new ClassificacaoEquipamento(Equipamento.BARRA);
        tabela.add(barra);

        ClassificacaoSexo masc = new ClassificacaoSexo(Sexo.MASCULINO);
        ClassificacaoSexo fem = new ClassificacaoSexo(Sexo.FEMININO);
        barra.add(masc);
        barra.add(fem);

        masc.add(new Nivel("Iniciante", 1.0, 0.0, 100.0));
        masc.add(new Nivel("Intermediário", 2.0, 100.0, 160.0));
        masc.add(new Nivel("Avançado", 3.0, 160.0, 200.0));
        masc.add(new Nivel("Altamente Avançado", 4.0, 200.0, null));

        fem.add(new Nivel("Iniciante", 1.0, 0.0, 60.0));
        fem.add(new Nivel("Intermediário", 2.0, 60.0, 100.0));
        fem.add(new Nivel("Avançado", 3.0, 100.0, 130.0));
        fem.add(new Nivel("Altamente Avançado", 4.0, 130.0, null));

        return new TesteForcaTerra("levantamento_terra", Unidade.KG, Equipamento.BARRA, tabela);
    }

    public static TesteDeForca criarAgachamento() {
        TabelaClassificacao tabela = new TabelaClassificacao();
        ClassificacaoEquipamento barra = new ClassificacaoEquipamento(Equipamento.BARRA);
        tabela.add(barra);

        ClassificacaoSexo masc = new ClassificacaoSexo(Sexo.MASCULINO);
        ClassificacaoSexo fem = new ClassificacaoSexo(Sexo.FEMININO);
        barra.add(masc);
        barra.add(fem);

        masc.add(new Nivel("Iniciante", 1.0, 0.0, 80.0));
        masc.add(new Nivel("Intermediário", 2.0, 80.0, 140.0));
        masc.add(new Nivel("Avançado", 3.0, 140.0, 180.0));
        masc.add(new Nivel("Altamente Avançado", 4.0, 180.0, null));

        fem.add(new Nivel("Iniciante", 1.0, 0.0, 50.0));
        fem.add(new Nivel("Intermediário", 2.0, 50.0, 90.0));
        fem.add(new Nivel("Avançado", 3.0, 90.0, 120.0));
        fem.add(new Nivel("Altamente Avançado", 4.0, 120.0, null));

        return new TesteForcaAgachamento("agachamento", Unidade.KG, Equipamento.BARRA, tabela);
    }

    public static TesteDeForca criarPuxada() {
        TabelaClassificacao tabela = new TabelaClassificacao();
        ClassificacaoEquipamento barra = new ClassificacaoEquipamento(Equipamento.BARRA_FIXA);
        tabela.add(barra);

        ClassificacaoSexo masc = new ClassificacaoSexo(Sexo.MASCULINO);
        ClassificacaoSexo fem = new ClassificacaoSexo(Sexo.FEMININO);
        barra.add(masc);
        barra.add(fem);

        masc.add(new Nivel("Iniciante", 1.0, 0.0, 5.0));
        masc.add(new Nivel("Intermediário", 2.0, 5.0, 10.0));
        masc.add(new Nivel("Avançado", 3.0, 10.0, 15.0));
        masc.add(new Nivel("Altamente Avançado", 4.0, 15.0, null));

        fem.add(new Nivel("Iniciante", 1.0, 0.0, 3.0));
        fem.add(new Nivel("Intermediário", 2.0, 3.0, 7.0));
        fem.add(new Nivel("Avançado", 3.0, 7.0, 10.0));
        fem.add(new Nivel("Altamente Avançado", 4.0, 10.0, null));

        return new TesteForcaPuxada("puxada", Unidade.REPETICAO, Equipamento.BARRA_FIXA, tabela);
    }
}
