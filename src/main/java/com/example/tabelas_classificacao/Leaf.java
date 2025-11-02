package com.example.tabelas_classificacao;

import com.example.Biometria;
import com.example.testes.Teste;

public abstract class Leaf implements Component{
    
    @Override
    public abstract Leaf classificar(Double resultado, Teste teste, Biometria biometria);

    @Override
    public abstract Leaf classificar(Double resultado, Class<? extends Component> tipoAlvo, Teste teste, Biometria biometria);

}
