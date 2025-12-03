package com.jales.prosup_spring.core.tabela_classificacao;

import com.example.Biometria;
import com.example.testes.Teste;
import org.springframework.data.annotation.Transient;

public interface Component {
    
    @Transient // Não persiste este método
    Leaf classificar(Double resultado, Teste teste, Biometria biometria);
    
    @Transient
    Leaf classificar(Double resultado, Class<? extends Component> tipoAlvo, Teste teste, Biometria biometria);
}