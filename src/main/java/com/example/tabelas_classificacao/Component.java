package com.example.tabelas_classificacao;

import com.example.Biometria;
import com.example.testes.Teste;

public interface Component {
    
    Leaf classificar(Double resultado, Teste teste, Biometria biometria);
    Leaf classificar(Double resultado, Class<? extends Component> tipoAlvo, Teste teste, Biometria biometria);
}
