package com.estudo.collection.set.ordenacao.exercicio01;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Iterator;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class CadastroProdutosTest {

    private CadastroProdutos cadastroProdutos;

    @BeforeEach
    void setUp() {
        cadastroProdutos = new CadastroProdutos();
    }

    @Test
    void adicionarProduto() {
        cadastroProdutos.adicionarProduto(1, "Produto A", 10.0, 5);
        cadastroProdutos.adicionarProduto(2, "Produto B", 20.0, 10);

        Set<Produto> produtos = cadastroProdutos.exibirProdutosPorNome();
        assertEquals(2, produtos.size());
        assertTrue(produtos.contains(new Produto("Produto A", 1, 10.0, 5)));
        assertTrue(produtos.contains(new Produto("Produto B", 2, 20.0, 10)));
    }

    @Test
    void exibirProdutosPorNome() {
        cadastroProdutos.adicionarProduto(1, "Produto B", 10.0, 5);
        cadastroProdutos.adicionarProduto(2, "Produto A", 20.0, 10);

        Set<Produto> produtos = cadastroProdutos.exibirProdutosPorNome();
        Iterator<Produto> iterator = produtos.iterator();

        assertEquals("Produto A", iterator.next().getNome());
        assertEquals("Produto B", iterator.next().getNome());
    }

    @Test
    void exibirProdutosPorPreco() {
        cadastroProdutos.adicionarProduto(1, "Produto A", 20.0, 5);
        cadastroProdutos.adicionarProduto(2, "Produto B", 10.0, 10);

        Set<Produto> produtos = cadastroProdutos.exibirProdutosPorPreco();
        Iterator<Produto> iterator = produtos.iterator();

        assertEquals(10.0, iterator.next().getPreco());
        assertEquals(20.0, iterator.next().getPreco());
    }
}
