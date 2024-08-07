package com.estudo.collection.set.operacaobasica.exercicio01;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ConjuntoConvidadosTest {

    private ConjuntoConvidados conjuntoConvidados;

    @BeforeEach
    void setUp() {
        conjuntoConvidados = new ConjuntoConvidados();
    }

    @Test
    void testAdicionarConvidado() {
        conjuntoConvidados.adicionarConvidados("Alice", 101);
        conjuntoConvidados.adicionarConvidados("Bob", 102);

        assertEquals(2, conjuntoConvidados.contarConvidados());
    }

    @Test
    void testRemoverConvidadoPorCodigoConvite() {
        conjuntoConvidados.adicionarConvidados("Alice", 101);
        conjuntoConvidados.adicionarConvidados("Bob", 102);

        conjuntoConvidados.removerConvidadoPorCodigoConvite(101);

        assertEquals(1, conjuntoConvidados.contarConvidados());
        assertThrows(RuntimeException.class, () -> conjuntoConvidados.removerConvidadoPorCodigoConvite(101));
    }

    @Test
    void testRemoverConvidadoPorCodigoConvite_ConjuntoVazio() {
        assertThrows(RuntimeException.class, () -> conjuntoConvidados.removerConvidadoPorCodigoConvite(101));
    }

    @Test
    void testRemoverConvidadoPorCodigoConvite_ConvidadoNaoEncontrado() {
        conjuntoConvidados.adicionarConvidados("Alice", 101);

        assertThrows(RuntimeException.class, () -> conjuntoConvidados.removerConvidadoPorCodigoConvite(999));
    }

    @Test
    void testContarConvidados() {
        assertEquals(0, conjuntoConvidados.contarConvidados());

        conjuntoConvidados.adicionarConvidados("Alice", 101);
        conjuntoConvidados.adicionarConvidados("Bob", 102);

        assertEquals(2, conjuntoConvidados.contarConvidados());
    }

    @Test
    void testExibirConvidados() {
        conjuntoConvidados.adicionarConvidados("Alice", 101);
        conjuntoConvidados.adicionarConvidados("Bob", 102);

        // Usar System.out para verificar a saída é menos ideal; preferencialmente, você deve verificar o conteúdo do conjunto de outra forma
        // Exemplo: criar uma forma de retornar a lista ou utilizar um mock para capturar a saída
        conjuntoConvidados.exibirConvidados(); // Apenas para visualização
    }
}
