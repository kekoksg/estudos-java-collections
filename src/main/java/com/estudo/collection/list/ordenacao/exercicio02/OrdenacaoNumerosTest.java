package com.estudo.collection.list.ordenacao.exercicio02;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class OrdenacaoNumerosTest {
    private OrdenacaoNumeros ordenacaoNumeros;

    @BeforeEach
    public void setUp() {
        ordenacaoNumeros = new OrdenacaoNumeros();
        List<Integer> numeros = Arrays.asList(3, 1, 4, 1, 5, 9, 2, 6, 5, 3, 5);
        for (int numero : numeros) {
            ordenacaoNumeros.adicionarNumero(numero);
        }
    }

    @Test
    public void testAdicionarNumero() {
        OrdenacaoNumeros numeros = new OrdenacaoNumeros();
        numeros.adicionarNumero(10);
        List<Integer> resultado = numeros.ordenarAscendente();
        assertEquals(1, resultado.size());
        assertEquals(10, resultado.get(0));
    }

    @Test
    public void testOrdenarAscendente() {
        List<Integer> esperado = Arrays.asList(1, 1, 2, 3, 3, 4, 5, 5, 5, 6, 9);
        List<Integer> resultado = ordenacaoNumeros.ordenarAscendente();
        assertEquals(esperado, resultado);
    }

    @Test
    public void testOrdenarDescendente() {
        List<Integer> esperado = Arrays.asList(9, 6, 5, 5, 5, 4, 3, 3, 2, 1, 1);
        List<Integer> resultado = ordenacaoNumeros.ordenarDescendente();
        assertEquals(esperado, resultado);
    }

    @Test
    public void testOrdenarAscendenteListaVazia() {
        OrdenacaoNumeros numerosVazia = new OrdenacaoNumeros();
        RuntimeException thrown = assertThrows(RuntimeException.class, () -> {
            numerosVazia.ordenarAscendente();
        });
        assertEquals("Lista vazia", thrown.getMessage());
    }

    @Test
    public void testOrdenarDescendenteListaVazia() {
        OrdenacaoNumeros numerosVazia = new OrdenacaoNumeros();
        RuntimeException thrown = assertThrows(RuntimeException.class, () -> {
            numerosVazia.ordenarDescendente();
        });
        assertEquals("Lista vazia", thrown.getMessage());
    }
}
