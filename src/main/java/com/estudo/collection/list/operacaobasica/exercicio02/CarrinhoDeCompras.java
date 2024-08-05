package com.estudo.collection.list.operacaobasica.exercicio02;

import java.util.ArrayList;
import java.util.List;

public class CarrinhoDeCompras {

    private final List<Item> carrinho;

    public CarrinhoDeCompras() {
        this.carrinho = new ArrayList<>();
    }

    public void adicionarItem(String nome, double preco, int quantidade){
        this.carrinho.add(new Item(nome, preco, quantidade));
    }

    public void removerItem(String nome) {
        List<Item> itensParaRemover = new ArrayList<>();
        if(!this.carrinho.isEmpty()){
            for(Item item : this.carrinho) {
                if (item.getNome().equalsIgnoreCase(nome)){
                    itensParaRemover.add(item);
                }
            }

            this.carrinho.removeAll(itensParaRemover);
        } else {
            throw new RuntimeException("O carrinho está vazio");
        }

    }

    public double calcularValorTotal() {
        double valorTotal = 0d;
        if(!this.carrinho.isEmpty()) {
            for (Item item : this.carrinho){
                valorTotal += item.getPreco() * item.getQuantidade();
            }

            return valorTotal;
        } else {
            throw new RuntimeException("O carrinho está vazio");
        }
    }

    public void exibirItens() {
        if(!this.carrinho.isEmpty()) {
            System.out.println(this.carrinho);
        } else {
            throw new RuntimeException("O carrinho está vazio");
        }
    }

    // Apenas para realização dos testes
    // Retorna uma cópia para evitar modificações externas
    public List<Item> getCarrinho() {
        return new ArrayList<>(this.carrinho);
    }

}
