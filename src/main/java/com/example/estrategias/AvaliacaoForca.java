package com.example.estrategias;

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

            Leaf classificacao = teste.classificar(resultado, ClassificacaoSexo.class, teste, biometria);
            

        }
        return null;
    }

}
