package com.estudo.collection.list.ordenacao.exercicio01;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class OrdenacaoPessoas {
    private final List<Pessoa> pessoaList;

    public OrdenacaoPessoas(){
        this.pessoaList = new ArrayList<>();
    }

    public void adicionarPessoas(String nome, int idade, double altura) {
        this.pessoaList.add(new Pessoa(nome, idade, altura));
    }

    public List<Pessoa> ordenarPorIdade() {
        if (this.pessoaList.isEmpty()) {
            throw new RuntimeException("Lista vazia");
        }

        List<Pessoa> pessoasPorIdade = new ArrayList<>(this.pessoaList);
        Collections.sort(pessoasPorIdade);

        return pessoasPorIdade;
    }

    public List<Pessoa> ordenarPorAltura(){
        if (this.pessoaList.isEmpty()) {
            throw new RuntimeException("Lista vazia");
        }

        List<Pessoa> pessoasPorAltura = new ArrayList<>(this.pessoaList);
        Collections.sort(pessoasPorAltura, new ComparatorPorAltura());

        return pessoasPorAltura;
    }
}
