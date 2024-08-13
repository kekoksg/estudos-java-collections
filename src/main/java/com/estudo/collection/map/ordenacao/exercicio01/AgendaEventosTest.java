package com.estudo.collection.map.ordenacao.exercicio01;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class AgendaEventosTest {

    private AgendaEventos agendaEventos;

    @BeforeEach
    public void setup() {
        agendaEventos = new AgendaEventos();
    }

    @Test
    public void testAdicionarEvento() {
        LocalDate data = LocalDate.of(2024, 8, 15);
        String nome = "Concerto de Rock";
        String atracao = "Banda XYZ";

        agendaEventos.adicionarEvento(data, nome, atracao);

        Evento proximoEvento = agendaEventos.obterProximoEvento();
        assertEquals(nome, proximoEvento.getNome());
        assertEquals(atracao, proximoEvento.getAtracao());
    }

    @Test
    public void testExibirAgenda() {
        LocalDate data1 = LocalDate.of(2024, 8, 15);
        LocalDate data2 = LocalDate.of(2024, 8, 20);
        LocalDate data3 = LocalDate.of(2024, 8, 10);

        agendaEventos.adicionarEvento(data1, "Concerto de Rock", "Banda XYZ");
        agendaEventos.adicionarEvento(data2, "Festa de Jazz", "Trio ABC");
        agendaEventos.adicionarEvento(data3, "Show de Pop", "Cantor DEF");

        agendaEventos.exibirAgenda();
    }

    @Test
    public void testObterProximoEvento() {
        LocalDate dataFutura = LocalDate.now().plusDays(5);
        LocalDate dataPassada = LocalDate.now().minusDays(5);

        agendaEventos.adicionarEvento(dataFutura, "Festa de Aniversário", "DJ Fulano");
        agendaEventos.adicionarEvento(dataPassada, "Reunião de Negócios", "Empresário XYZ");

        Evento proximoEvento = agendaEventos.obterProximoEvento();

        assertEquals("Festa de Aniversário", proximoEvento.getNome());
        assertEquals("DJ Fulano", proximoEvento.getAtracao());
    }

    @Test
    public void testObterProximoEventoSemEventosFuturos() {
        LocalDate dataPassada = LocalDate.now().minusDays(5);

        agendaEventos.adicionarEvento(dataPassada, "Reunião de Negócios", "Empresário XYZ");

        Evento proximoEvento = agendaEventos.obterProximoEvento();

        assertNull(proximoEvento);
    }
}
