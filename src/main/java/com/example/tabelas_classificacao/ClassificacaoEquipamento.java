package com.example.tabelas_classificacao;

import com.example.Biometria;
import com.example.enums.Equipamento;
import com.example.testes.Teste;

public class ClassificacaoEquipamento extends Composite {
    private Equipamento equipamento;

    public ClassificacaoEquipamento(Equipamento equipamento) {
        this.equipamento = equipamento;
    }

    @Override
    public Leaf classificar(Double resultado, Class<? extends Component> tipoAlvo, Teste teste, Biometria biometria) {
        System.out.println("🔍 [DEBUG] Iniciando classificação em ClassificacaoEquipamento: " + equipamento);
        System.out.println("🔹 Resultado recebido: " + resultado);
        System.out.println("🔹 Tipo alvo: " + tipoAlvo.getSimpleName());
        System.out.println("🔹 Total de filhos: " + children.size());

        for (Component child : children) {
            if (child == null) {
                System.out.println("⚠️  [DEBUG] Child nulo — ignorando...");
                continue;
            }

            System.out.println("➡️  [DEBUG] Verificando child: " + child.getClass().getSimpleName());

            if (tipoAlvo.isInstance(child)) {
                System.out.println("✅ [DEBUG] Child é instância de " + tipoAlvo.getSimpleName());
                Leaf classificacao = child.classificar(resultado, teste, biometria);

                if (classificacao != null) {
                    System.out.println("🏁 [DEBUG] Classificação encontrada: " + classificacao);
                    return classificacao;
                } else {
                    System.out.println("❌ [DEBUG] Nenhuma classificação retornada por " + child.getClass().getSimpleName());
                }

            } else if (child instanceof Composite) {
                System.out.println("🔁 [DEBUG] Child é um Composite — entrando em recursão...");
                Leaf classificacao = child.classificar(resultado, tipoAlvo, teste, biometria);

                if (classificacao != null) {
                    System.out.println("🏁 [DEBUG] Classificação encontrada dentro do Composite: " + classificacao);
                    return classificacao;
                } else {
                    System.out.println("❌ [DEBUG] Retorno nulo dentro do Composite.");
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
