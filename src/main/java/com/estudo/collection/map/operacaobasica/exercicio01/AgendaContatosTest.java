package com.estudo.collection.map.operacaobasica.exercicio01;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class AgendaContatosTest {

    private AgendaContatos agendaContatos;

    @BeforeEach
    public void setup() {
        agendaContatos = new AgendaContatos();
    }

    @Test
    public void testAdicionarContato() {
        agendaContatos.adicionarContato("João", 123456789);
        Integer telefone = agendaContatos.pesquisarPorNome("João");
        assertEquals(123456789, telefone);
    }

    @Test
    public void testRemoverContatoExistente() {
        agendaContatos.adicionarContato("Maria", 987654321);
        agendaContatos.removerContato("Maria");
        Integer telefone = agendaContatos.pesquisarPorNome("Maria");
        assertNull(telefone);
    }

    @Test
    public void testRemoverContatoInexistente() {
        agendaContatos.adicionarContato("Pedro", 555555555);
        agendaContatos.removerContato("Maria");  // Tenta remover um contato que não existe
        Integer telefone = agendaContatos.pesquisarPorNome("Pedro");
        assertEquals(555555555, telefone);
    }

    @Test
    public void testPesquisarContatoExistente() {
        agendaContatos.adicionarContato("João", 123456789);
        Integer telefone = agendaContatos.pesquisarPorNome("João");
        assertEquals(123456789, telefone);
    }

    @Test
    public void testPesquisarContatoInexistente() {
        agendaContatos.adicionarContato("Ana", 111111111);
        Integer telefone = agendaContatos.pesquisarPorNome("Beto");  // Contato não existe
        assertNull(telefone);
    }

    @Test
    public void testPesquisarContatoComAgendaVazia() {
        Integer telefone = agendaContatos.pesquisarPorNome("João");
        assertNull(telefone);
    }
}
