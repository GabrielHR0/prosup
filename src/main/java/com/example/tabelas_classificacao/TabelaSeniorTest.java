package com.example.tabelas_classificacao;

import java.util.ArrayList;
import java.util.List;

import com.example.Biometria;
import com.example.testes.Teste;

public class TabelaSeniorTest extends Composite{

    @Override
    public Leaf classificar(Double resultado, Teste teste, Biometria biometria) {
        for (Component child : children) {
            Leaf classificacao = child.classificar(resultado, teste, biometria);
            if (classificacao != null) {
                return classificacao;
            }
        }
        return null;
    }

    public List<Leaf> classificacoes(Double resultado, Class<? extends Component> tipoAlvo, Teste teste, Biometria biometria) {
            List<Leaf> leafs = new ArrayList<>();

            for (Component child : children) {
                
                if (tipoAlvo.isInstance(child)) {
                    if (child instanceof Composite compositeAlvo) {
                        for (Component subChild : compositeAlvo.children) {
                            if (subChild != null) {
                                Leaf classificacao = subChild.classificar(resultado, teste, biometria);
                                if (classificacao != null) {
                                    leafs.add(classificacao);
                                }
                            }
                        }
                    } else if (child instanceof Composite){
                        child.classificar(resultado, tipoAlvo, teste, biometria);
                    }
                }
            }
        return null;
    }
}
