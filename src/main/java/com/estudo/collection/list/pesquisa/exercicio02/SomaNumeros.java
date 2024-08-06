package com.estudo.collection.list.pesquisa.exercicio02;

import java.util.ArrayList;
import java.util.List;

public class SomaNumeros {
    List<Integer> numeroList;

    public SomaNumeros(){
        this.numeroList = new ArrayList<>();
    }

    public void adicionarNumero(int numero){
        this.numeroList.add(numero);
    }

    public int calcularSoma(){
        if(this.numeroList.isEmpty()){
            throw new RuntimeException("Lista de numeros vazia");
        }

        int soma = 0;
        for(Integer numero : numeroList) {
            soma += numero;
        }
        return soma;
    }

    public int encontrarMaiorNumero(){
        if(this.numeroList.isEmpty()){
            throw new RuntimeException("Lista de numeros vazia");
        }

        int maiorNumero = Integer.MIN_VALUE;
        for(Integer numero : numeroList){
            if(numero >= maiorNumero) {
                maiorNumero = numero;
            }
        }
        return maiorNumero;
    }

    public int encontrarMenorNumero(){
        if(this.numeroList.isEmpty()){
            throw new RuntimeException("Lista de numeros vazia");
        }

        int menorNumero = Integer.MAX_VALUE;
        for(Integer numero : numeroList){
            if(numero <= menorNumero) {
                menorNumero = numero;
            }
        }
        return menorNumero;
    }

    public void exibirNumeros(){
        if(this.numeroList.isEmpty()){
            throw new RuntimeException("Lista de numeros vazia");
        }

        System.out.println(this.numeroList);
    }
}
