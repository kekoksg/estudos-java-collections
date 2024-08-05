package com.estudo.collection.list.operacaobasica.exercicio01;

public class Tarefa {

    private final String descricao;

    public Tarefa(String descricao){
        this.descricao = descricao;
    }

    public String getDescricao() {
        return this.descricao;
    }

    @Override
    public String toString(){
        return this.descricao;
    }

}
