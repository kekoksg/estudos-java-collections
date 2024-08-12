package com.estudo.collection.map.pesquisa.exercicio02;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class ContagemPalavrasTest {

    private ContagemPalavras contagemPalavras;

    @BeforeEach
    public void setup() {
        contagemPalavras = new ContagemPalavras();
    }

    @Test
    public void testAdicionarPalavra() {
        contagemPalavras.adicionarPalavra("teste", 5);
        String palavraMaisFrequente = contagemPalavras.encontrarPalavraMaisFrequente();
        assertEquals("teste", palavraMaisFrequente);
    }

    @Test
    public void testRemoverPalavra() {
        contagemPalavras.adicionarPalavra("teste", 5);
        contagemPalavras.removerPalavra("teste");
        String palavraMaisFrequente = contagemPalavras.encontrarPalavraMaisFrequente();
        assertNull(palavraMaisFrequente);
    }

    @Test
    public void testEncontrarPalavraMaisFrequente() {
        contagemPalavras.adicionarPalavra("java", 10);
        contagemPalavras.adicionarPalavra("python", 8);
        contagemPalavras.adicionarPalavra("c++", 12);

        String palavraMaisFrequente = contagemPalavras.encontrarPalavraMaisFrequente();
        assertEquals("c++", palavraMaisFrequente);
    }

    @Test
    public void testExibirContagemPalavras() {
        contagemPalavras.adicionarPalavra("java", 10);
        contagemPalavras.adicionarPalavra("python", 8);

        contagemPalavras.exibirContagemPalavras();
    }
}
