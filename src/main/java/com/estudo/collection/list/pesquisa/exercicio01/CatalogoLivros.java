package com.estudo.collection.list.pesquisa.exercicio01;

import java.util.ArrayList;
import java.util.List;

public class CatalogoLivros {
    private final List<Livro> livroList;

    public CatalogoLivros(){
        this.livroList = new ArrayList<>();
    }

    public void adicionarLivro(String titulo, String autor, int anoPublicacao) {
        this.livroList.add(new Livro(titulo, autor, anoPublicacao));
    }

    public List<Livro> pesquisarPorAutor(String autor){
        if (this.livroList.isEmpty()) {
            throw new RuntimeException("Lista de livros vazia");
        }

        List<Livro> livrosPorAutor = new ArrayList<>();

        for(Livro livro : this.livroList) {
            if (livro.getAutor().equalsIgnoreCase(autor)){
                livrosPorAutor.add(livro);
            }
        }

        return livrosPorAutor;
    }

    public List<Livro> pesquisarPorIntervaloAnos(int anoInicial, int anoFinal) {
        if (this.livroList.isEmpty()) {
            throw new RuntimeException("Lista de livros vazia");
        }

        List<Livro> livrosPorIntervaloAnos = new ArrayList<>();

        for(Livro livro : this.livroList) {
            if (livro.getAnoPublicacao() >= anoInicial && livro.getAnoPublicacao() <= anoFinal){
                livrosPorIntervaloAnos.add(livro);
            }
        }

        return livrosPorIntervaloAnos;
    }

    public Livro pesquisarPorTitulo(String titulo) {
        if (this.livroList.isEmpty()) {
            throw new RuntimeException("Lista de livros vazia");
        }

        for (Livro livro : this.livroList){
            if (livro.getTitulo().equalsIgnoreCase(titulo)){
                return livro;
            }
        }

        throw new RuntimeException("Livro não encontrado");
    }
}
