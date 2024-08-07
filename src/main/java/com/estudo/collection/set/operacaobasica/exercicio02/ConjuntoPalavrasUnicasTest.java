package com.estudo.collection.set.operacaobasica.exercicio02;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ConjuntoPalavrasUnicasTest {

    private ConjuntoPalavrasUnicas conjunto;

    @BeforeEach
    void setUp() {
        conjunto = new ConjuntoPalavrasUnicas();
    }

    @Test
    void testAdicionarPalavras() {
        conjunto.adicionarPalavras("teste");
        assertTrue(conjunto.verificarPalavra("teste"), "Palavra deve estar presente no conjunto.");
    }

    @Test
    void testRemoverPalavra() {
        conjunto.adicionarPalavras("remover");
        conjunto.removerPalavra("remover");
        assertFalse(conjunto.verificarPalavra("remover"), "Palavra deve ser removida do conjunto.");
    }

    @Test
    void testRemoverPalavraConjuntoVazio() {
        conjunto.removerPalavra("nãoExistente");
        // Testa apenas a ausência de exceções.
        // Saída padrão não é verificada em testes automatizados por padrão.
    }

    @Test
    void testRemoverPalavraNaoExistente() {
        conjunto.adicionarPalavras("existente");
        conjunto.removerPalavra("nãoExistente");
        assertTrue(conjunto.verificarPalavra("existente"), "Palavra existente não deve ser removida.");
    }

    @Test
    void testVerificarPalavra() {
        conjunto.adicionarPalavras("verificar");
        assertTrue(conjunto.verificarPalavra("verificar"), "Palavra deve estar presente no conjunto.");
        assertFalse(conjunto.verificarPalavra("nãoExistente"), "Palavra não existente não deve estar presente no conjunto.");
    }
}
