package com.estudo.collection.list.operacaobasica.exercicio01;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class ListaTarefaTest {

    private ListaTarefa listaTarefa;

    @BeforeEach
    public void setup() {
        listaTarefa = new ListaTarefa();
    }

    @Test
    public void testAdicionarTarefa() {
        listaTarefa.adicionarTarefa("Estudar Java");
        assertEquals(1, listaTarefa.obterNumeroTotalTarefas());
        assertTrue(listaTarefa.obterDescricoesTarefas().contains("Estudar Java"));
    }

    @Test
    public void testRemoverTarefa() {
        listaTarefa.adicionarTarefa("Estudar Java");
        listaTarefa.adicionarTarefa("Ler um livro");
        listaTarefa.removerTarefa("Estudar Java");

        assertEquals(1, listaTarefa.obterNumeroTotalTarefas());
        assertFalse(listaTarefa.obterDescricoesTarefas().contains("Estudar Java"));
        assertTrue(listaTarefa.obterDescricoesTarefas().contains("Ler um livro"));
    }

    @Test
    public void testObterNumeroTotalTarefas() {
        listaTarefa.adicionarTarefa("Estudar Java");
        listaTarefa.adicionarTarefa("Ler um livro");

        assertEquals(2, listaTarefa.obterNumeroTotalTarefas());
    }

    @Test
    public void testObterDescricoesTarefas() {
        listaTarefa.adicionarTarefa("Estudar Java");
        listaTarefa.adicionarTarefa("Ler um livro");

        List<String> descricoes = listaTarefa.obterDescricoesTarefas();
        assertEquals(2, descricoes.size());
        assertTrue(descricoes.contains("Estudar Java"));
        assertTrue(descricoes.contains("Ler um livro"));
    }

    @Test
    public void testImprimeDescricoesTarefas() {
        listaTarefa.adicionarTarefa("Estudar Java");
        listaTarefa.adicionarTarefa("Ler um livro");

        listaTarefa.imprimeDescricoesTarefas();
    }
}
