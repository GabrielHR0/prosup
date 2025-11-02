package com.example.testes;

import com.example.Biometria;
import com.example.enums.Unidade;
import com.example.tabelas_classificacao.Component;
import com.example.tabelas_classificacao.Composite;
import com.example.tabelas_classificacao.Leaf;

public abstract class Teste {
    protected String nome;
    protected Unidade unidade;
    protected Composite tabelaClassificacao;

    public Teste(String nome, Unidade unidade, Composite tabelaClassificacao) {
        this.nome = nome;
        this.unidade = unidade;
        this.tabelaClassificacao = tabelaClassificacao;
    }
    
    public Leaf classificar(Double resultado, Class<? extends Component> tipoAlvo, Teste teste, Biometria biometria) {
        if (tabelaClassificacao != null) {
            return tabelaClassificacao.classificar(resultado, tipoAlvo, teste, biometria);
        }
        return null;
    }

    public Composite getTabelaClassificacao() {
        return tabelaClassificacao;
    }

    public void setTabelaClassificacao(Composite tabelaClassificacao) {
        this.tabelaClassificacao = tabelaClassificacao;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Unidade getUnidade() {
        return unidade;
    }

    public void setUnidade(Unidade unidade) {
        this.unidade = unidade;
    }

}
