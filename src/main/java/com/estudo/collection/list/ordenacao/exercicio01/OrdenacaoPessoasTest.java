package com.estudo.collection.list.ordenacao.exercicio01;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class OrdenacaoPessoasTest {
    private OrdenacaoPessoas ordenacaoPessoas;

    @BeforeEach
    public void setUp() {
        ordenacaoPessoas = new OrdenacaoPessoas();
        ordenacaoPessoas.adicionarPessoas("Alice", 30, 1.65);
        ordenacaoPessoas.adicionarPessoas("Bob", 25, 1.75);
        ordenacaoPessoas.adicionarPessoas("Charlie", 35, 1.80);
    }

    @Test
    public void testAdicionarPessoas() {
        OrdenacaoPessoas op = new OrdenacaoPessoas();
        op.adicionarPessoas("Daniel", 40, 1.85);
        List<Pessoa> lista = op.ordenarPorIdade();
        assertEquals(1, lista.size());
        assertEquals("Daniel", lista.get(0).getNome());
    }

    @Test
    public void testOrdenarPorIdade() {
        List<Pessoa> pessoasOrdenadas = ordenacaoPessoas.ordenarPorIdade();
        assertEquals(3, pessoasOrdenadas.size());
        assertEquals("Bob", pessoasOrdenadas.get(0).getNome());
        assertEquals("Alice", pessoasOrdenadas.get(1).getNome());
        assertEquals("Charlie", pessoasOrdenadas.get(2).getNome());
    }

    @Test
    public void testOrdenarPorAltura() {
        List<Pessoa> pessoasOrdenadas = ordenacaoPessoas.ordenarPorAltura();
        assertEquals(3, pessoasOrdenadas.size());
        assertEquals("Alice", pessoasOrdenadas.get(0).getNome());
        assertEquals("Bob", pessoasOrdenadas.get(1).getNome());
        assertEquals("Charlie", pessoasOrdenadas.get(2).getNome());
    }

    @Test
    public void testOrdenarPorIdadeListaVazia() {
        OrdenacaoPessoas op = new OrdenacaoPessoas();
        RuntimeException thrown = assertThrows(RuntimeException.class, () -> {
            op.ordenarPorIdade();
        });
        assertEquals("Lista vazia", thrown.getMessage());
    }

    @Test
    public void testOrdenarPorAlturaListaVazia() {
        OrdenacaoPessoas op = new OrdenacaoPessoas();
        RuntimeException thrown = assertThrows(RuntimeException.class, () -> {
            op.ordenarPorAltura();
        });
        assertEquals("Lista vazia", thrown.getMessage());
    }
}
