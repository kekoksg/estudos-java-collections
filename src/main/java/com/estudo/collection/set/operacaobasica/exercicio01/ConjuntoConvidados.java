package com.estudo.collection.set.operacaobasica.exercicio01;

import java.util.HashSet;
import java.util.Set;

public class ConjuntoConvidados {
    private Set<Convidado> convidadoSet;

    public ConjuntoConvidados(){
        this.convidadoSet = new HashSet<>();
    }

    public void adicionarConvidados(String nome, int codigoConvite){
        this.convidadoSet.add(new Convidado(nome, codigoConvite));
    }

    public void removerConvidadoPorCodigoConvite(int codigoConvite){
        if (this.convidadoSet.isEmpty()){
            throw new RuntimeException("Conjunto de convidados vazio");
        }

        Convidado convidadoParaRemover = null;

        for (Convidado convidado : convidadoSet){
            if (convidado.getCodigoConvite() == codigoConvite){
                convidadoParaRemover = convidado;
                break;
            }
        }

        if (convidadoParaRemover == null) {
            throw new RuntimeException("Convidado não encontrado");
        }

        this.convidadoSet.remove(convidadoParaRemover);
    }

    public int contarConvidados(){
        return this.convidadoSet.size();
    }

    public void exibirConvidados(){
        System.out.println(this.convidadoSet);
    }
}
