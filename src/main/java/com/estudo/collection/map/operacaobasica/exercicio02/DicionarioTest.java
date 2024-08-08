package com.estudo.collection.map.operacaobasica.exercicio02;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class DicionarioTest {

    private Dicionario dicionario;

    @BeforeEach
    public void setup() {
        dicionario = new Dicionario();
    }

    @Test
    public void testAdicionarPalavra() {
        dicionario.adicionarPalavra("Programação", "Ato de programar");
        String definicao = dicionario.pesquisarPorPalavra("Programação");
        assertEquals("Ato de programar", definicao);
    }

    @Test
    public void testRemoverPalavraExistente() {
        dicionario.adicionarPalavra("Java", "Linguagem de programação");
        dicionario.removerPalavra("Java");
        String definicao = dicionario.pesquisarPorPalavra("Java");
        assertNull(definicao);
    }

    @Test
    public void testRemoverPalavraInexistente() {
        dicionario.adicionarPalavra("Python", "Linguagem de programação");
        dicionario.removerPalavra("C++");  // Tenta remover uma palavra que não existe
        String definicao = dicionario.pesquisarPorPalavra("Python");
        assertEquals("Linguagem de programação", definicao);
    }

    @Test
    public void testPesquisarPalavraExistente() {
        dicionario.adicionarPalavra("HTML", "Linguagem de marcação");
        String definicao = dicionario.pesquisarPorPalavra("HTML");
        assertEquals("Linguagem de marcação", definicao);
    }

    @Test
    public void testPesquisarPalavraInexistente() {
        dicionario.adicionarPalavra("CSS", "Folha de estilos");
        String definicao = dicionario.pesquisarPorPalavra("JavaScript");  // Palavra não existe
        assertNull(definicao);
    }

    @Test
    public void testPesquisarPalavraComDicionarioVazio() {
        String definicao = dicionario.pesquisarPorPalavra("Java");
        assertNull(definicao);
    }
}
