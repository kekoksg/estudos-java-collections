package com.estudo.collection.set.pesquisa.exercicio02;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class ListaTarefasTest {

    private ListaTarefas listaTarefas;

    @BeforeEach
    void setUp() {
        listaTarefas = new ListaTarefas();
    }

    @Test
    void adicionarTarefa() {
        listaTarefas.adicionarTarefa("Estudar Java");
        assertEquals(1, listaTarefas.contarTarefas());
        Set<Tarefa> tarefas = listaTarefas.obterTarefasPendentes();
        assertEquals(1, tarefas.size());
        assertTrue(tarefas.contains(new Tarefa("Estudar Java")));
    }

    @Test
    void removerTarefa() {
        listaTarefas.adicionarTarefa("Estudar Spring");
        listaTarefas.removerTarefa("Estudar Spring");
        assertEquals(0, listaTarefas.contarTarefas());
    }

    @Test
    void removerTarefaNaoExistente() {
        listaTarefas.adicionarTarefa("Estudar Spring");
        listaTarefas.removerTarefa("Estudar Java");
        assertEquals(1, listaTarefas.contarTarefas());
    }

    @Test
    void marcarTarefaConcluida() {
        listaTarefas.adicionarTarefa("Estudar JUnit");
        listaTarefas.marcarTarefaConcluida("Estudar JUnit");
        Set<Tarefa> tarefasConcluidas = listaTarefas.obterTarefasConcluidas();
        assertEquals(1, tarefasConcluidas.size());
        assertTrue(tarefasConcluidas.contains(new Tarefa("Estudar JUnit", true)));
    }

    @Test
    void marcarTarefaPendente() {
        listaTarefas.adicionarTarefa("Estudar JUnit");
        listaTarefas.marcarTarefaConcluida("Estudar JUnit");
        listaTarefas.marcarTarefaPendente("Estudar JUnit");
        Set<Tarefa> tarefasPendentes = listaTarefas.obterTarefasPendentes();
        assertEquals(1, tarefasPendentes.size());
        assertTrue(tarefasPendentes.contains(new Tarefa("Estudar JUnit", false)));
    }

    @Test
    void obterTarefasConcluidas() {
        listaTarefas.adicionarTarefa("Estudar Java");
        listaTarefas.adicionarTarefa("Estudar Spring");
        listaTarefas.marcarTarefaConcluida("Estudar Java");
        Set<Tarefa> tarefasConcluidas = listaTarefas.obterTarefasConcluidas();
        assertEquals(1, tarefasConcluidas.size());
        assertTrue(tarefasConcluidas.contains(new Tarefa("Estudar Java", true)));
    }

    @Test
    void obterTarefasPendentes() {
        listaTarefas.adicionarTarefa("Estudar Java");
        listaTarefas.adicionarTarefa("Estudar Spring");
        listaTarefas.marcarTarefaConcluida("Estudar Java");
        Set<Tarefa> tarefasPendentes = listaTarefas.obterTarefasPendentes();
        assertEquals(1, tarefasPendentes.size());
        assertTrue(tarefasPendentes.contains(new Tarefa("Estudar Spring", false)));
    }

    @Test
    void limparListaTarefas() {
        listaTarefas.adicionarTarefa("Estudar Java");
        listaTarefas.adicionarTarefa("Estudar Spring");
        listaTarefas.limparListaTarefas();
        assertEquals(0, listaTarefas.contarTarefas());
    }
}
