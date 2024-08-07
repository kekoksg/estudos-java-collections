package com.estudo.collection.set.operacaobasica.exercicio02;

import java.util.HashSet;
import java.util.Set;

public class ConjuntoPalavrasUnicas {
    private Set<String> palavrasSet;

    public ConjuntoPalavrasUnicas() {
        this.palavrasSet = new HashSet<>();
    }

    public void adicionarPalavras(String palavra) {
        this.palavrasSet.add(palavra);
    }

    public void removerPalavra(String palavra) {
        if (this.palavrasSet.isEmpty()) {
            System.out.println("Conjunto vazio");
            return;
        }

        boolean removido = this.palavrasSet.remove(palavra);

        if (!removido) {
            System.out.println("Palavra não encontrada");
        }
    }

    public boolean verificarPalavra(String palavra) {
        return this.palavrasSet.contains(palavra);
    }

    public void exibirPalavrasUnicas() {
        System.out.println(this.palavrasSet);
    }

}
