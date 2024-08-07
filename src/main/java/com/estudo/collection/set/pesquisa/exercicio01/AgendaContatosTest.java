package com.estudo.collection.set.pesquisa.exercicio01;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class AgendaContatosTest {

    private AgendaContatos agenda;

    @BeforeEach
    void setUp() {
        agenda = new AgendaContatos();
    }

    @Test
    void adicionarContato() {
        agenda.adicionarContato("Alice", 12345);
        Set<Contato> contatos = agenda.pesquisarPorNome("Alice");
        assertEquals(1, contatos.size());
        assertTrue(contatos.contains(new Contato("Alice", 12345)));
    }

    @Test
    void pesquisarPorNome() {
        agenda.adicionarContato("Bob", 67890);
        agenda.adicionarContato("Bobby", 54321);

        Set<Contato> contatos = agenda.pesquisarPorNome("Bob");
        assertEquals(2, contatos.size());
        assertTrue(contatos.contains(new Contato("Bob", 67890)));
        assertTrue(contatos.contains(new Contato("Bobby", 54321)));
    }

    @Test
    void pesquisarPorNomeInexistente() {
        Set<Contato> contatosInexistentes = agenda.pesquisarPorNome("Charlie");
        assertTrue(contatosInexistentes.isEmpty());
    }

    @Test
    void atualizarNumeroContato() {
        agenda.adicionarContato("David", 11111);
        Contato atualizado = agenda.atualizarNumeroContato("David", 22222);

        assertNotNull(atualizado);
        assertEquals(22222, atualizado.getTelefone());

        Set<Contato> contatos = agenda.pesquisarPorNome("David");
        assertEquals(1, contatos.size());
        assertTrue(contatos.contains(new Contato("David", 22222)));
    }

    @Test
    void atualizarNumeroContatoInexistente() {
        Contato atualizado = agenda.atualizarNumeroContato("Eve", 33333);
        assertNull(atualizado);
    }
}
