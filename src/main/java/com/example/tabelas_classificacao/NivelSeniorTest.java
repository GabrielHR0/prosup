package com.example.tabelas_classificacao;

import com.example.Biometria;
import com.example.testes.Teste;

public class NivelSeniorTest extends Leaf {

    @Override
    public Leaf classificar(Double resultado, Teste teste, Biometria biometria) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Leaf classificar(Double resultado, Class<? extends Component> tipoAlvo, Teste teste, Biometria biometria) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
}
