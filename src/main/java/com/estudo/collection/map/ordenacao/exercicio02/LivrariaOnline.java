package com.estudo.collection.map.ordenacao.exercicio02;

import java.util.*;

public class LivrariaOnline {
    private Map<String, Livro> livrosMap;

    public LivrariaOnline(){
        this.livrosMap = new HashMap<>();
    }

    public void adicionarLivro(String link, String titulo, String autor, double preco) {
        this.livrosMap.put(link, new Livro(titulo, autor, preco));
    }

    public void removerLivro(String titulo) {
        if (this.livrosMap.isEmpty()) {
            System.out.println("Livraria vazia");
            return;
        }

        List<String> keysParaRemover = new ArrayList<>();

        for (Map.Entry<String, Livro> entry : livrosMap.entrySet()) {
            String tituloLivro = entry.getValue().getTitulo();

            if (tituloLivro.equalsIgnoreCase(titulo)) {
                keysParaRemover.add(entry.getKey());
            }
        }

        for (String key : keysParaRemover) {
            this.livrosMap.remove(key);
        }
    }

    public void removerLivro02(String titulo) {
        if (this.livrosMap.isEmpty()) {
            System.out.println("Livraria vazia");
            return;
        }

        Iterator<Map.Entry<String, Livro>> iterator = livrosMap.entrySet().iterator();

        while (iterator.hasNext()){
            Map.Entry<String, Livro> entry = iterator.next();

            if (entry.getValue().getTitulo().equalsIgnoreCase(titulo)) {
                iterator.remove();
            }
        }
    }

    public void removerLivro03(String titulo) {
        if (this.livrosMap.isEmpty()) {
            System.out.println("Livraria vazia");
            return;
        }

        livrosMap.entrySet().removeIf(entry -> entry.getValue().getTitulo().equalsIgnoreCase(titulo));
    }

    public Map<String, Livro> exibirLivrosOrdenadosPorPreco() {
        List<Map.Entry<String, Livro>> livrosParaOrdenarPorPreco = new ArrayList<>(livrosMap.entrySet());

        livrosParaOrdenarPorPreco.sort(Comparator.comparing(entry -> entry.getValue().getPreco()));

        Map<String, Livro> livrosOrdenados = new LinkedHashMap<>();
        for (Map.Entry<String, Livro> entry : livrosParaOrdenarPorPreco) {
            livrosOrdenados.put(entry.getKey(), entry.getValue());
        }

        return livrosOrdenados;
    }

    public Map<String, Livro> pesquisarLivrosPorAutor(String autor) {
        Map<String, Livro> livrosPorAutor = new LinkedHashMap<>();

        for(Map.Entry<String, Livro> entry : livrosMap.entrySet()) {
            if (entry.getValue().getAutor().equalsIgnoreCase(autor)) {
                livrosPorAutor.put(entry.getKey(), entry.getValue());
            }
        }

        return livrosPorAutor;
    }

    public Livro obterLivroMaisCaro() {
        Livro livroMaisCaro = null;
        double maiorPreco = Double.MIN_VALUE;

        for(Map.Entry<String, Livro> entry : livrosMap.entrySet()){
            if(entry.getValue().getPreco() >= maiorPreco) {
                maiorPreco = entry.getValue().getPreco();
                livroMaisCaro = entry.getValue();
            }
        }

        return livroMaisCaro;
    }

    public Livro obterLivroMaisBarato() {
        Livro livroMaisBarato = null;
        double menorPreco = Double.MAX_VALUE;

        for(Map.Entry<String, Livro> entry : livrosMap.entrySet()){
            if(entry.getValue().getPreco() <= menorPreco) {
                menorPreco = entry.getValue().getPreco();
                livroMaisBarato = entry.getValue();
            }
        }

        return livroMaisBarato;
    }
}
