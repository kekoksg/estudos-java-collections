package com.estudo.collection.set.pesquisa.exercicio01;

import java.util.HashSet;
import java.util.Set;

public class AgendaContatos {

    private Set<Contato> conjuntoContato;

    public AgendaContatos(){
        this.conjuntoContato = new HashSet<>();
    }

    public void adicionarContato(String nome, int telefone) {
        this.conjuntoContato.add(new Contato(nome, telefone));
    }

    public void exibirContatos() {
        System.out.println(this.conjuntoContato);
    }

    public Set<Contato> pesquisarPorNome(String nome) {
        Set<Contato> contatosPorNome = new HashSet<>();

        for(Contato contato : conjuntoContato) {
            if(contato.getNome().startsWith(nome)) {
                contatosPorNome.add(contato);
            }
        }

        if(contatosPorNome.isEmpty()) {
            System.out.println("Contato não encontrado");
        }

        return contatosPorNome;
    }

    public Contato atualizarNumeroContato(String nome, int novoNumero) {
        Contato contatoAtualizado = null;

        for(Contato contato : conjuntoContato) {
            if(contato.getNome().equalsIgnoreCase(nome)) {
                contato.setTelefone(novoNumero);
                contatoAtualizado = contato;
                break;
            }
        }

        if (contatoAtualizado == null) {
            System.out.println("Contato não encontrado");
        }

        return contatoAtualizado;
    }

}
