package com.example.tabelas_classificacao;

import com.example.Biometria;
import com.example.enums.Sexo;
import com.example.testes.Teste;

public class ClassificacaoSexo extends Composite {
    private Sexo sexo;

    public ClassificacaoSexo(Sexo sexo) {
        this.sexo = sexo;
    }

    @Override
    public Leaf classificar(Double resultado, Class<? extends Component> tipoAlvo, Teste teste, Biometria biometria) {
            if (biometria.getSexo() != this.sexo) return null;
            for (Component child : children) {
                if (child != null){
                    if (tipoAlvo.isInstance(child)){
                        Leaf classificacao = child.classificar(resultado, teste, biometria);
                        if (classificacao != null) {
                            return classificacao;
                        }
                    } else if (child instanceof Composite){
                        Leaf classificacao = child.classificar(resultado, tipoAlvo, teste, biometria);
                        if (classificacao != null) {
                            return classificacao;
                        }
                    }
                }
            }
        return null;
    }

    public Sexo getSexo() {
        return sexo;
    }

    public void setSexo(Sexo sexo) {
        this.sexo = sexo;
    }
}
