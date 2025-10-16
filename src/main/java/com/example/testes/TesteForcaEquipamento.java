package com.example.testes;

import com.example.Biometria;
import com.example.Contexto;
import com.example.enums.Equipamento;
import com.example.enums.Unidade;

public class TesteForcaEquipamento extends Teste{
    
    private Equipamento equipmento;

    @Override
    public Object avaliar(Contexto contexto){
        if (this.unidade == Unidade.REPETICAO){
            //retornar somente a entrada, a classificação é feita na avaliacao
            return contexto.get(this.nome);
        }
        if (this.unidade == Unidade.KG){
            Biometria biometria = (Biometria) contexto.get("Biometria");
            Double carga = (Double) contexto.get("carga");

            return (carga / biometria.getMassa()) * 100;

        }

        return null;

    }
    
}
