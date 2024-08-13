package com.estudo.collection.map.ordenacao.exercicio01;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class AgendaEventos {
    private Map<LocalDate, Evento> eventoMap;

    public AgendaEventos(){
        this.eventoMap = new HashMap<>();
    }

    public void adicionarEvento(LocalDate data, String nome, String atracao) {
        Evento evento = new Evento(nome, atracao);
        this.eventoMap.put(data, evento);
    }

    public void exibirAgenda(){
        Map<LocalDate, Evento> eventoTreeMap = new TreeMap<>(eventoMap);
        System.out.println(eventoTreeMap);
    }

    public Evento obterProximoEvento() {
        Evento proximoEvento = null;
        LocalDate dataAtual = LocalDate.now();

        Map<LocalDate, Evento> eventoTreeMap = new TreeMap<>(eventoMap);
        for (Map.Entry<LocalDate, Evento> entry : eventoTreeMap.entrySet()) {
            LocalDate dataEvento = entry.getKey();
            if(dataEvento.equals(dataAtual) || dataEvento.isAfter(dataAtual)) {
                proximoEvento = entry.getValue();
            }
        }

        return proximoEvento;
    }
}
