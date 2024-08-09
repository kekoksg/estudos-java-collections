package com.estudo.collection.map.pesquisa.exercicio01;

import java.util.HashMap;
import java.util.Map;

public class EstoqueProdutos {
    private Map<Long, Produto> estoqueProdutosMap;

    public EstoqueProdutos() {
        this.estoqueProdutosMap = new HashMap<>();
    }

    public void adicionarProduto(long codigo, String nome, int quantidade, double preco) {
        this.estoqueProdutosMap.put(codigo, new Produto(nome, quantidade, preco));
    }

    public void exibirProdutos() {
        System.out.println(this.estoqueProdutosMap);
    }

    public double calcularValorTotalEstoque() {
        double valorTotalEstoque = 0d;
        if(!estoqueProdutosMap.isEmpty()){
            for(Produto produto : estoqueProdutosMap.values()) {
                valorTotalEstoque += produto.getPreco() * produto.getQuantidade();
            }
        }

        return valorTotalEstoque;
    }

    public Produto obterProdutoMaisCaro() {
        Produto produtoMaisCaro = null;
        double maiorPreco = Double.MIN_VALUE;

        if(!estoqueProdutosMap.isEmpty()) {
            for (Produto produto : estoqueProdutosMap.values()) {
                if (produto.getPreco() >= maiorPreco) {
                    produtoMaisCaro = produto;
                    maiorPreco = produto.getPreco();
                }
            }
        }

        return produtoMaisCaro;
    }

    public Produto obterProdutoMaisBarato() {
        Produto produtoMaisBarato = null;
        double menorPreco = Double.MAX_VALUE;

        if(!estoqueProdutosMap.isEmpty()) {
            for (Produto produto : estoqueProdutosMap.values()) {
                if (produto.getPreco() <= menorPreco) {
                    produtoMaisBarato = produto;
                    menorPreco = produto.getPreco();
                }
            }
        }

        return produtoMaisBarato;
    }

    public Produto obterProdutoMaiorQuantidadeValorTotalNoEstoque() {
        Produto produtoMaiorValorTotal = null;
        double maiorValorTotal = 0d;

        if(!estoqueProdutosMap.isEmpty()){
            for(Produto produto : estoqueProdutosMap.values()) {
                double valorTotalProduto = produto.getPreco() * produto.getQuantidade();
                if (valorTotalProduto > maiorValorTotal) {
                    produtoMaiorValorTotal = produto;
                    maiorValorTotal = valorTotalProduto;
                }
            }
        }

        return produtoMaiorValorTotal;
    }
}
