package com.estudo.collection.map.pesquisa.exercicio01;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class EstoqueProdutosTest {
    private EstoqueProdutos estoque;

    @BeforeEach
    public void setUp() {
        estoque = new EstoqueProdutos();
        estoque.adicionarProduto(1L, "Produto A", 10, 15.0);
        estoque.adicionarProduto(2L, "Produto B", 5, 30.0);
        estoque.adicionarProduto(3L, "Produto C", 7, 25.0);
    }

    @Test
    public void testCalcularValorTotalEstoque() {
        double valorTotal = estoque.calcularValorTotalEstoque();
        assertEquals(10 * 15.0 + 5 * 30.0 + 7 * 25.0, valorTotal, 0.01);
    }

    @Test
    public void testObterProdutoMaisCaro() {
        Produto produtoMaisCaro = estoque.obterProdutoMaisCaro();
        assertNotNull(produtoMaisCaro);
        assertEquals("Produto B", produtoMaisCaro.getNome());
        assertEquals(30.0, produtoMaisCaro.getPreco());
    }

    @Test
    public void testObterProdutoMaisBarato() {
        Produto produtoMaisBarato = estoque.obterProdutoMaisBarato();
        assertNotNull(produtoMaisBarato);
        assertEquals("Produto A", produtoMaisBarato.getNome());
        assertEquals(15.0, produtoMaisBarato.getPreco());
    }

    @Test
    public void testObterProdutoMaiorQuantidadeValorTotalNoEstoque() {
        Produto produtoMaiorValorTotal = estoque.obterProdutoMaiorQuantidadeValorTotalNoEstoque();
        assertNotNull(produtoMaiorValorTotal);
        assertEquals("Produto C", produtoMaiorValorTotal.getNome());
        assertEquals(175.0, produtoMaiorValorTotal.getPreco() * produtoMaiorValorTotal.getQuantidade());
    }

}
