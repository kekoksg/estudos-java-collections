package com.estudo.collection.list.ordenacao.exercicio02;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class OrdenacaoNumeros {
    private List<Integer> integerList;

    public OrdenacaoNumeros() {
        this.integerList = new ArrayList<>();
    }

    public void adicionarNumero(int numero) {
        this.integerList.add(numero);
    }

    public List<Integer> ordenarAscendente() {
        if(this.integerList.isEmpty()){
            throw new RuntimeException("Lista vazia");
        }

        List<Integer> integerAsc = new ArrayList<>(this.integerList);
        Collections.sort(integerAsc);
        return integerAsc;
    }

    public List<Integer> ordenarDescendente() {
        if(this.integerList.isEmpty()){
            throw new RuntimeException("Lista vazia");
        }

        List<Integer> integerDesc = new ArrayList<>(this.integerList);
        Collections.sort(integerDesc, Collections.reverseOrder());
        return integerDesc;
    }
}
