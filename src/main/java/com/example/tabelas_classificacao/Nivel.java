package com.example.tabelas_classificacao;

import com.example.Biometria;
import com.example.testes.Teste;

public class Nivel extends Leaf{
    
    private String classificacao;
    private Double pontuacao;
    private Double min;

    public Nivel(String classificacao, Double pontuacao, Double min) {
        this.classificacao = classificacao;
        this.pontuacao = pontuacao;
        this.min = min;
    }

    @Override
    public Leaf classificar(Double resultado, Teste teste, Biometria biometria){
        if ( resultado >= this.min) {
            return this;
        }
        return null;
    }

    @Override
    public Leaf classificar(Double resultado, Class<? extends Component> tipoAlvo, Teste teste, Biometria biometria){
        if ( resultado >= this.min) {
            return this;
        }
        return null;
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
}
