package com.estudo.collection.set.pesquisa.exercicio02;

import java.util.HashSet;
import java.util.Set;

public class ListaTarefas {
    private Set<Tarefa> conjuntoTarefa;

    public ListaTarefas() {
        this.conjuntoTarefa = new HashSet<>();
    }

    public void adicionarTarefa(String descricao) {
        this.conjuntoTarefa.add(new Tarefa(descricao));
    }

    public void removerTarefa(String descricao) {
        if(this.conjuntoTarefa.isEmpty()) {
            System.out.println("O conjunto está vazio");
            return;
        }

        Tarefa tarefaParaRemover = obterTarefaPorDescricao(descricao);

        if (tarefaParaRemover == null) {
            System.out.println("Tarefa não encontrada");
        } else {
            this.conjuntoTarefa.remove(tarefaParaRemover);
        }
    }

    public void exibirTarefas() {
        System.out.println(this.conjuntoTarefa);
    }

    public int contarTarefas() {
       return this.conjuntoTarefa.size();
    }

    public Set<Tarefa> obterTarefasConcluidas() {
        Set<Tarefa> tarefasConcluidas = new HashSet<>();

        for (Tarefa tarefa : conjuntoTarefa) {
            if (tarefa.isConcluido()) {
                tarefasConcluidas.add(tarefa);
            }
        }

        if (tarefasConcluidas.isEmpty()) {
            System.out.println("Nenhuma tarefa concluida");
        }

        return tarefasConcluidas;
    }

    public Set<Tarefa> obterTarefasPendentes() {
        Set<Tarefa> tarefasPendentes = new HashSet<>();

        for (Tarefa tarefa : conjuntoTarefa) {
            if (!tarefa.isConcluido()) {
                tarefasPendentes.add(tarefa);
            }
        }

        if (tarefasPendentes.isEmpty()) {
            System.out.println("Nenhuma tarefa pendente");
        }

        return tarefasPendentes;
    }

    private Tarefa obterTarefaPorDescricao(String descricao) {
        Tarefa tarefa = null;
        for (Tarefa t : conjuntoTarefa) {
            if (t.getDescricao().equalsIgnoreCase(descricao)) {
                tarefa = t;
                break;
            }
        }
        return tarefa;
    }

    private void alterarEstadoTarefa(String descricao, boolean estadoTarefa){
        Tarefa tarefa = obterTarefaPorDescricao(descricao);

        if(tarefa != null) {
            if(tarefa.isConcluido() != estadoTarefa) {
                tarefa.setConcluido(estadoTarefa);
            }
        } else {
            System.out.println("Tarefa não encontrada");
        }

    }

    public void marcarTarefaConcluida(String descricao) {
        alterarEstadoTarefa(descricao, true);
    }

    public void marcarTarefaPendente(String descricao) {
        alterarEstadoTarefa(descricao, false);
    }

    public void limparListaTarefas() {
        if (this.conjuntoTarefa.isEmpty()) {
            System.out.println("A lista já está vazia");
        } else {
            this.conjuntoTarefa.clear();
        }
    }
}
