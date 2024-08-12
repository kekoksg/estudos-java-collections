package com.estudo.collection.map.pesquisa.exercicio02;

import java.util.HashMap;
import java.util.Map;

public class ContagemPalavras {

    private Map<String, Integer> contagemPalavrasMap;

    public ContagemPalavras() {
        this.contagemPalavrasMap = new HashMap<>();
    }

    public void adicionarPalavra(String palavra, Integer contagem) {
        this.contagemPalavrasMap.put(palavra, contagem);
    }

    public void removerPalavra(String palavra) {
        if (!contagemPalavrasMap.isEmpty()) {
            this.contagemPalavrasMap.remove(palavra);
        } else {
            System.out.println("Lista de palavras vazia");
        }
    }

    public void exibirContagemPalavras() {
        System.out.println(contagemPalavrasMap);
    }

    public String encontrarPalavraMaisFrequente() {
        int maiorContagem = 0;
        String palavraMaisFrequente = null;

        for (Map.Entry<String, Integer> entry : contagemPalavrasMap.entrySet()){
            if (entry.getValue() > maiorContagem) {
                maiorContagem = entry.getValue();
                palavraMaisFrequente = entry.getKey();
            }
        }
        return palavraMaisFrequente;
    }
}
