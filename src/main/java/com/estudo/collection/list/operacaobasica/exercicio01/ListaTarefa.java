package com.estudo.collection.list.operacaobasica.exercicio01;

import java.util.ArrayList;
import java.util.List;

public class ListaTarefa {

    private final List<Tarefa> tarefaList;

    public ListaTarefa(){
        this.tarefaList = new ArrayList<>();
    }

    public void adicionarTarefa(String descricao) {
        this.tarefaList.add(new Tarefa(descricao));
    }

    public void removerTarefa(String descricao) {
        List<Tarefa> tarefasParaRemover = new ArrayList<>();
        for (Tarefa tarefa: this.tarefaList) {
            if (tarefa.getDescricao().equalsIgnoreCase(descricao)) {
                tarefasParaRemover.add(tarefa);
            }
        }
        this.tarefaList.removeAll(tarefasParaRemover);
    }

    public int obterNumeroTotalTarefas(){
        return this.tarefaList.size();
    }

    public List<String> obterDescricoesTarefas(){
        List<String> listaDescricaoTarefas = new ArrayList<>();
        for(Tarefa tarefa: this.tarefaList){
            listaDescricaoTarefas.add(tarefa.getDescricao());
        }
        return listaDescricaoTarefas;
    }

    public void imprimeDescricoesTarefas(){
        System.out.println(tarefaList);
    }
}
