package com.estudo.collection.list.operacaobasica.exercicio02;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class CarrinhoDeComprasTest {

    private CarrinhoDeCompras carrinhoDeCompras;

    @BeforeEach
    public void setup() {
        carrinhoDeCompras = new CarrinhoDeCompras();
    }

    @Test
    public void testAdicionarItem() {
        carrinhoDeCompras.adicionarItem("Livro", 29.90, 2);
        List<Item> itens = carrinhoDeCompras.getCarrinho();
        assertEquals(1, itens.size());
        Item item = itens.get(0);
        assertEquals("Livro", item.getNome());
        assertEquals(29.90, item.getPreco());
        assertEquals(2, item.getQuantidade());
    }

    @Test
    public void testRemoverItem() {
        carrinhoDeCompras.adicionarItem("Livro", 29.90, 2);
        carrinhoDeCompras.adicionarItem("Caneta", 2.50, 5);
        carrinhoDeCompras.removerItem("Livro");
        List<Item> itens = carrinhoDeCompras.getCarrinho();
        assertEquals(1, itens.size());
        assertEquals("Caneta", itens.get(0).getNome());
    }

    @Test
    public void testRemoverItemComNomeDiferenteCapitalizacao() {
        carrinhoDeCompras.adicionarItem("Livro", 29.90, 2);
        carrinhoDeCompras.adicionarItem("Caneta", 2.50, 5);
        carrinhoDeCompras.removerItem("liVro");
        List<Item> itens = carrinhoDeCompras.getCarrinho();
        assertEquals(1, itens.size());
        assertEquals("Caneta", itens.get(0).getNome());
    }

    @Test
    public void testRemoverItemInexistente() {
        carrinhoDeCompras.adicionarItem("Livro", 29.90, 2);
        carrinhoDeCompras.adicionarItem("Caneta", 2.50, 5);
        carrinhoDeCompras.removerItem("Caderno");
        List<Item> itens = carrinhoDeCompras.getCarrinho();
        assertEquals(2, itens.size());
    }

    @Test
    public void testRemoverItemCarrinhoVazio() {
        RuntimeException thrown = assertThrows(RuntimeException.class,
                () -> carrinhoDeCompras.removerItem("Livro"));
        assertEquals("O carrinho está vazio", thrown.getMessage());
    }

    @Test
    public void testCalcularValorTotal() {
        carrinhoDeCompras.adicionarItem("Livro", 29.90, 2);
        carrinhoDeCompras.adicionarItem("Caneta", 2.50, 5);
        double valorTotal = carrinhoDeCompras.calcularValorTotal();
        assertEquals((29.90 * 2) + (2.50 * 5), valorTotal);
    }

    @Test
    public void testCalcularValorTotalCarrinhoVazio() {
        RuntimeException thrown = assertThrows(RuntimeException.class,
                () -> carrinhoDeCompras.calcularValorTotal()
        );
        assertEquals("O carrinho está vazio", thrown.getMessage());
    }

    @Test
    public void testExibirItens() {
        carrinhoDeCompras.adicionarItem("Livro", 29.90, 2);
        carrinhoDeCompras.adicionarItem("Caneta", 2.50, 5);
        carrinhoDeCompras.exibirItens(); // Isso imprimirá na saída do console
    }

    @Test
    public void testExibirItensCarrinhoVazio() {
        RuntimeException thrown = assertThrows(RuntimeException.class,
                () -> carrinhoDeCompras.exibirItens());
        assertEquals("O carrinho está vazio", thrown.getMessage());
    }

    @Test
    public void testCalcularValorTotalItemQuantidadeZero() {
        carrinhoDeCompras.adicionarItem("Livro", 29.90, 0);
        double valorTotal = carrinhoDeCompras.calcularValorTotal();
        assertEquals(0.0, valorTotal);
    }

    @Test
    public void testCalcularValorTotalItemPrecoZero() {
        carrinhoDeCompras.adicionarItem("Livro", 0.0, 5);
        double valorTotal = carrinhoDeCompras.calcularValorTotal();
        assertEquals(0.0, valorTotal);
    }
}
