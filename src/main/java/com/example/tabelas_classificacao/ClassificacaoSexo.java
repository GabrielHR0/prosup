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
        System.out.println("🔍 [DEBUG] Iniciando classificação em ClassificacaoSexo: " + sexo);

        if (biometria.getSexo() != this.sexo) {
            System.out.println("🚫 [DEBUG] Sexo não corresponde. Esperado: " + this.sexo + " / Recebido: " + biometria.getSexo());
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

        System.out.println("🚫 [DEBUG] Nenhuma classificação encontrada para o sexo " + sexo);
        return null;
    }

    public Sexo getSexo() {
        return sexo;
    }

    public void setSexo(Sexo sexo) {
        this.sexo = sexo;
    }
}
