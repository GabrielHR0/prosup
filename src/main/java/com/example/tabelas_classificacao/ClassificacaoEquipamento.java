package com.example.tabelas_classificacao;

import com.example.Biometria;
import com.example.enums.Equipamento;
import com.example.testes.Teste;
import com.example.testes.TesteDeForca;

public class ClassificacaoEquipamento extends Composite {
    private Equipamento equipamento;

    public ClassificacaoEquipamento(Equipamento equipamento) {
        this.equipamento = equipamento;
    }

    @Override
    public Leaf classificar(Double resultado, Class<? extends Component> tipoAlvo, Teste teste, Biometria biometria) {
        System.out.println("🔍 [DEBUG] Iniciando classificação em ClassificacaoEquipamento: " + equipamento);
        TesteDeForca tForca = (TesteDeForca) teste;
        if(this.equipamento != tForca.getEquipamento()){
            return null;
        }

        for (Component child : children) {
            if (child == null) {
                continue;
            }

            if (tipoAlvo.isInstance(child)) {
                System.out.println("✅ [DEBUG] Child é instância de " + tipoAlvo.getSimpleName());
                Leaf classificacao = child.classificar(resultado, teste, biometria);

                if (classificacao != null) {
                    System.out.println("🏁 [DEBUG] Classificação encontrada: " + classificacao);
                    return classificacao;
                }

            } else if (child instanceof Composite) {
                System.out.println("🔁 [DEBUG] Child é um Composite — entrando em recursão...");
                Leaf classificacao = child.classificar(resultado, tipoAlvo, teste, biometria);

                if (classificacao != null) {
                    return classificacao;
                }

            } else {
                System.out.println("⚙️  [DEBUG] Child não é do tipo alvo nem Composite — ignorando.");
            }
        }

        System.out.println("🚫 [DEBUG] Nenhuma classificação encontrada para o equipamento " + equipamento);
        return null;
    }

    public Equipamento getEquipamento() {
        return equipamento;
    }

    public void setEquipamento(Equipamento equipamento) {
        this.equipamento = equipamento;
    }
}
