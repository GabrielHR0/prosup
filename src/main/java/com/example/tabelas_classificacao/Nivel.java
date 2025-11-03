package com.example.tabelas_classificacao;

import com.example.Biometria;
import com.example.testes.Teste;

public class Nivel extends Leaf{
    
    private String classificacao;
    private Double pontuacao;
    private Double min;
    private Double max = null;

    public Nivel(Double pontuacao){
        this.pontuacao = pontuacao;
    }

    public Nivel(String classificacao, Double pontuacao, Double min, Double max) {
        this.classificacao = classificacao;
        this.pontuacao = pontuacao;
        this.min = min;
        this.max = max;
    }

    @Override
    public Leaf classificar(Double resultado, Teste teste, Biometria biometria){
        System.out.println("   ⚖️ [DEBUG] Verificando nível: " + this);
        System.out.println("      ➤ Min: " + this.min + " | Max: " + this.max + " | Resultado: " + resultado);

        boolean dentroFaixa = resultado >= this.min && (this.max == null || resultado < this.max);

        if (dentroFaixa) {
            System.out.println("✅ Resultado dentro da faixa! Classificação: " + this);
            return this;
        } else {
            System.out.println("❌ Fora da faixa.");
        }
        return null;
    }

    @Override
    public Leaf classificar(Double resultado, Class<? extends Component> tipoAlvo, Teste teste, Biometria biometria) {
        boolean dentroFaixa = resultado >= this.min && (this.max == null || resultado < this.max);

        if (dentroFaixa) {
            return this;
        }
        return null;
    }


    @Override
    public String toString() {
        return this.classificacao + " (" + this.pontuacao + " pontos, min: " + this.min + ")";
    }

    public String getClassificacao() {
        return classificacao;
    }

    public void setClassificacao(String classificacao) {
        this.classificacao = classificacao;
    }

    public Double getPontuacao() {
        return pontuacao;
    }

    public void setPontuacao(Double pontuacao) {
        this.pontuacao = pontuacao;
    }

    public Double getMin() {
        return min;
    }

    public void setMin(Double min) {
        this.min = min;
    }

    public Double getMax() {
        return max;
    }

    public void setMax(Double max) {
        this.max = max;
    }
}
