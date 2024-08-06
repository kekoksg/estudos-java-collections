package com.estudo.collection.list.pesquisa.exercicio02;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class SomaNumerosTest {
    private SomaNumeros somaNumeros;

    @BeforeEach
    public void setUp() {
        somaNumeros = new SomaNumeros();
        somaNumeros.adicionarNumero(10);
        somaNumeros.adicionarNumero(20);
        somaNumeros.adicionarNumero(30);
        somaNumeros.adicionarNumero(-5);
    }

    @Test
    public void testCalcularSoma() {
        int soma = somaNumeros.calcularSoma();
        assertEquals(55, soma, "A soma dos números deve ser 55");
    }

    @Test
    public void testEncontrarMaiorNumero() {
        int maior = somaNumeros.encontrarMaiorNumero();
        assertEquals(30, maior, "O maior número deve ser 30");
    }

    @Test
    public void testEncontrarMenorNumero() {
        int menor = somaNumeros.encontrarMenorNumero();
        assertEquals(-5, menor, "O menor número deve ser -5");
    }

    @Test
    public void testCalcularSomaListaVazia() {
        somaNumeros = new SomaNumeros(); // Reinicia o objeto para uma lista vazia
        RuntimeException thrown = assertThrows(RuntimeException.class,
                () -> somaNumeros.calcularSoma());
        assertEquals("Lista de numeros vazia", thrown.getMessage());
    }

    @Test
    public void testEncontrarMaiorNumeroListaVazia() {
        somaNumeros = new SomaNumeros(); // Reinicia o objeto para uma lista vazia
        RuntimeException thrown = assertThrows(RuntimeException.class,
                () -> somaNumeros.encontrarMaiorNumero());
        assertEquals("Lista de numeros vazia", thrown.getMessage());
    }

    @Test
    public void testEncontrarMenorNumeroListaVazia() {
        somaNumeros = new SomaNumeros(); // Reinicia o objeto para uma lista vazia
        RuntimeException thrown = assertThrows(RuntimeException.class,
                () -> somaNumeros.encontrarMenorNumero());
        assertEquals("Lista de numeros vazia", thrown.getMessage());
    }

    @Test
    public void testExibirNumerosListaVazia() {
        somaNumeros = new SomaNumeros(); // Reinicia o objeto para uma lista vazia
        RuntimeException thrown = assertThrows(RuntimeException.class,
                () -> somaNumeros.exibirNumeros());
        assertEquals("Lista de numeros vazia", thrown.getMessage());
    }
}
