package com.example.tabelas_classificacao;

import java.util.ArrayList;
import java.util.List;

import com.example.Biometria;
import com.example.testes.Teste;

public abstract class Composite implements Component {
    
    protected final List<Component> children = new ArrayList<>();

    public void add(Component component){
        this.children.add(component);
    }

    public void remove(Component component){
        this.children.remove(component);
    }

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

    @Override
    public Leaf classificar(Double resultado, Class<? extends Component> tipoAlvo, Teste teste, Biometria biometria) {
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

    public List<Component> getChildren() {
        return children;
    }
}
