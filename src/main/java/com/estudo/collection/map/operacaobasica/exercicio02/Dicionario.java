package com.estudo.collection.map.operacaobasica.exercicio02;

import java.util.HashMap;
import java.util.Map;

public class Dicionario {
    private Map<String, String> palavrasMap;

    public Dicionario(){
        this.palavrasMap = new HashMap<>();
    }

    public void adicionarPalavra(String palavra, String definicao) {
        this.palavrasMap.put(palavra, definicao);
    }

    public void removerPalavra(String palavra) {
        if(!this.palavrasMap.isEmpty()) {
            this.palavrasMap.remove(palavra);
        } else {
            System.out.println("Dicionario vazio");
        }
    }

    public void exibirPalavras() {
        System.out.println(this.palavrasMap);
    }

    public String pesquisarPorPalavra(String palavra) {
        if (this.palavrasMap.isEmpty()){
            System.out.println("Dicionario vazio");
            return null;
        }

        String definicaoPorPalavra = this.palavrasMap.get(palavra);

        if(definicaoPorPalavra == null) {
            System.out.println("Palavra não encontrada");
        }

        return definicaoPorPalavra;
    }
}
