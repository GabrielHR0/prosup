package com.example.estrategias;

import java.util.ArrayList;
import java.util.List;

import com.example.Biometria;
import com.example.enums.Equipamento;
import com.example.enums.Sexo;
import com.example.enums.Unidade;
import com.example.tabelas_classificacao.ClassificacaoSexo;
import com.example.tabelas_classificacao.Leaf;
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

            System.out.println(
                "teste: "+ teste.getNome()+ "\n"+
                "entrada: "+ teste.getEntrada() +"\n"+
                "resultado: "+ resultado
            );

            Leaf classificacao = teste.classificar(resultado, ClassificacaoSexo.class, teste, biometria);
            niveis.add(classificacao);
            System.out.println(classificacao.toString());

        }

        
        return null;
    }

}
