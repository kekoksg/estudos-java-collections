package com.estudo.collection.map.operacaobasica.exercicio01;

import java.util.HashMap;
import java.util.Map;

public class AgendaContatos {
    private Map<String, Integer> contatoMap;

    public AgendaContatos(){
        this.contatoMap = new HashMap<>();
    }

    public void adicionarContato(String nome, Integer telefone){
        this.contatoMap.put(nome, telefone);
    }

    public void removerContato(String nome) {
        if(!this.contatoMap.isEmpty()){
            this.contatoMap.remove(nome);
        } else {
            System.out.println("Agenda está vazia");
        }
    }

    public void exibirContatos(){
        System.out.println(this.contatoMap);
    }

    public Integer pesquisarPorNome(String nome) {
        if(this.contatoMap.isEmpty()) {
            System.out.println("Agenda está vazia");
            return null;
        }

        Integer telefonePorNome = this.contatoMap.get(nome);

        if(telefonePorNome == null) {
            System.out.println("Contato não encontrado");
        }

        return telefonePorNome;
    }
}
