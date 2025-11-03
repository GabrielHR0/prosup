package com.example.estrategias;

import java.util.ArrayList;
import java.util.List;

import com.example.Biometria;
import com.example.enums.Equipamento;
import com.example.enums.Sexo;
import com.example.enums.Unidade;
import com.example.tabelas_classificacao.ClassificacaoSexo;
import com.example.tabelas_classificacao.Leaf;
import com.example.tabelas_classificacao.Nivel;
import com.example.testes.TesteDeForca;

public class AvaliacaoForca implements AvaliacaoEstrategia<TesteDeForca>{
    
    @Override
    public Object avaliar(List<TesteDeForca> testes, Biometria biometria){

        List<Leaf> niveis = new ArrayList<>(); 

        for (TesteDeForca teste : testes) {
            Double entrada = teste.getEntrada();
            Unidade unidade  = teste.getUnidade();
            Equipamento equipamento = teste.getEquipamento();
            Double massaCorporal = biometria.getMassa();
            Sexo genero = biometria.getSexo();

            Double resultado = 0.0;

            if (unidade == Unidade.KG) {
                resultado = (
                    entrada / massaCorporal * 100
                    );
            } else if(unidade == Unidade.REPETICAO){
                resultado = entrada;
            }

            Leaf classificacao = teste.classificar(resultado, ClassificacaoSexo.class, biometria);
            niveis.add(classificacao);
            System.out.println(classificacao.toString());
        }

        System.out.println("\nNiveis de cada teste:");

        for (Leaf nivel : niveis) {
            System.out.println(nivel.toString());
        }

        Double pontucaoFinal = 0.0;
        for (Leaf nivel : niveis) {
            Nivel nivelConvertido = (Nivel)nivel;
            Double pontucaoObtida = nivelConvertido.getPontuacao();
            pontucaoFinal += pontucaoObtida;
        }
        Nivel classificacao = this.construirNivel(pontucaoFinal/niveis.size());
        
        return classificacao;
    }

    public Nivel construirNivel(Double pontuacao){

        Nivel nivel = new Nivel(pontuacao);

        Double altAvancadoMin = 4.0;
        Double avancadoMin = 3.0;
        Double intermediarioMin = 2.0;
        Double inicianteMin = 0.0;
        
        if (pontuacao.equals(altAvancadoMin)){
            nivel.setClassificacao("Altamente avançado");
            nivel.setMin(altAvancadoMin);
        } else if (pontuacao >=avancadoMin && pontuacao < altAvancadoMin) {
            nivel.setClassificacao("Avançado");
            nivel.setMin(avancadoMin);
            nivel.setMax(altAvancadoMin);
        } else if(pontuacao >= intermediarioMin && pontuacao < avancadoMin){
            nivel.setClassificacao("Intermediário");
            nivel.setMin(intermediarioMin);
            nivel.setMax(avancadoMin);
        } else if(pontuacao >= inicianteMin && pontuacao < intermediarioMin){
            nivel.setClassificacao("Iniciante");
            nivel.setMin(inicianteMin);
            nivel.setMax(intermediarioMin);
        }

        return nivel;
    }



}
