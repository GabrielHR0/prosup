package com.example.tabelas_classificacao;

import com.example.Biometria;
import com.example.enums.Equipamento;
import com.example.testes.Teste;

public class ClassificacaoEquipamento extends Composite {
    private Equipamento equipamento;

    public ClassificacaoEquipamento(Equipamento equipamento){
        this.equipamento = equipamento;
    }

    @Override
    public Leaf classificar(Double resultado, Class<? extends Component> tipoAlvo, Teste teste, Biometria biometria) {
            for (Component child : children) {
                if (tipoAlvo.isInstance(child)){
                    if (child != null){
                        Leaf classificacao = child.classificar(resultado, teste, biometria);
                        if (classificacao != null) {
                            return classificacao;
                        }
                    }
                } else if (child instanceof Composite){
                    Leaf classificacao = child.classificar(resultado, tipoAlvo, teste, biometria);
                    if (classificacao != null) {
                        return classificacao;
                    }
                }
            }
        return null;
    }

    public Equipamento getEquipamento() {
        return equipamento;
    }

    public void setEquipamento(Equipamento equipamento) {
        this.equipamento = equipamento;
    }
}
