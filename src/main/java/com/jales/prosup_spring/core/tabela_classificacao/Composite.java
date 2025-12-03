package com.jales.prosup_spring.core.tabela_classificacao;

import java.util.ArrayList;
import java.util.List;
import com.example.Biometria;
import com.example.testes.Teste;

@Getter
@Document(collection = "components")
public abstract class Composite implements Component {

    @Id
    private String id;

    protected List<Component> children = new ArrayList<>();

    @Transient
    public void add(Component component) {
        children.add(component);
    }

    @Transient
    public void remove(Component component) {
        children.remove(component);
    }

    @Override
    @Transient
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
    @Transient
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

}