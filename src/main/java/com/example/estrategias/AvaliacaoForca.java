package com.example.estrategias;

import java.io.File;
import java.io.IOException;
import java.util.List;

import com.example.Biometria;
import com.example.Contexto;
import com.example.enums.Equipamento;
import com.example.enums.Genero;
import com.example.enums.Unidade;
import com.example.testes.TesteDeForca;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

public class AvaliacaoForca implements AvaliacaoEstrategia<TesteDeForca>{
    
    @Override
    public Contexto avaliar(List<TesteDeForca> testes, Biometria biometria){

        Contexto resposta = new Contexto();

        for (TesteDeForca teste : testes) {
            Double entrada = teste.getEntrada();
            Unidade unidade  = teste.getUnidade();
            Equipamento equipamento = teste.getEquipamento();
            Double massaCorporal = biometria.getMassa();
            Genero genero = biometria.getGenero();

            Double resultado = 0.0;

            if (unidade == Unidade.KG) {
                resultado = (
                    entrada / massaCorporal * 100
                    );
            } else if(unidade == Unidade.REPETICAO){
                resultado = entrada;
            }

            Contexto classificacaoTeste = this.classificar(resultado, biometria, teste);
            Double nivelTeste = (Double) classificacaoTeste.get("nivel");
            resposta.put(teste.getNome(), nivelTeste);
        }

        final Double[] soma = {0.0};
        resposta.getMap().forEach((chave, valor) -> soma[0] += (Double) valor);

        Double media = soma[0] / resposta.getMap().size();
        resposta.put("resultado", media);
        return resposta;
    }

    public Contexto classificar(Double resultado, Biometria biometria, TesteDeForca teste){
            ObjectMapper mapper = new ObjectMapper();
            Contexto resposta = new Contexto();
            try { 
                File arquivo = new File("src/main/java/com/example/tabelasClassificao/Forca.json");
                JsonNode root = mapper.readTree(arquivo);

                JsonNode niveis = root
                .get(teste.getNome())
                .get(Equipamento.BARRA.toString())
                .get(biometria.getGenero().toString())
                .get("niveis");

                for (JsonNode nivel : niveis){
                    if (resultado >= nivel.get("min").asDouble()){
                        Double nivelNumero = nivel.get("nivel").asDouble();
                        String classificacao = nivel.get("classificacao").asText();
                        resposta.put("nivel", nivelNumero);
                    }
                }
                return resposta;
            } catch(IOException e){
                    System.err.println("Erro ao classificar: " + e.getMessage());
                    return null;
            }
    }
}
