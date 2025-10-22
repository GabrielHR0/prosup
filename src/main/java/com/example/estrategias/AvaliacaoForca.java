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
        for (TesteDeForca teste : testes) {
            Double entrada = teste.getEntrada();
            Unidade unidade  = teste.getUnidade();
            Equipamento equipamento = teste.getEquipamento();
            Double massaCorporal = biometria.getMassa();
            Genero genero = biometria.getGenero();

            Double resultado;

            if (unidade == Unidade.KG) {
                resultado = (
                    entrada / massaCorporal * 100
                    );
            } else if(unidade == Unidade.REPETICAO){
                resultado = entrada;
            }



        }
        return contexto;
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
                        int nivelNumero = nivel.get("nivel").asInt();
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
