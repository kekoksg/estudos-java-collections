package com.estudo.collection.set.ordenacao.exercicio02;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class GerenciadorAlunosTest {

    private GerenciadorAlunos gerenciadorAlunos;

    @BeforeEach
    public void setup() {
        gerenciadorAlunos = new GerenciadorAlunos();
    }

    @Test
    public void testAdicionarAluno() {
        gerenciadorAlunos.adicionarAluno("João", 12345L, 8.5);
        assertTrue(gerenciadorAlunos.alunoExiste(12345L));
    }

    @Test
    public void testRemoverAlunoExistente() {
        gerenciadorAlunos.adicionarAluno("Maria", 54321L, 7.5);
        gerenciadorAlunos.removerAluno(54321L);
        assertFalse(gerenciadorAlunos.alunoExiste(54321L));
    }

    @Test
    public void testRemoverAlunoInexistente() {
        gerenciadorAlunos.adicionarAluno("Pedro", 98765L, 9.0);
        gerenciadorAlunos.removerAluno(11111L);  // Tenta remover um aluno que não existe
        assertTrue(gerenciadorAlunos.alunoExiste(98765L));  // Verifica se o aluno original ainda está presente
    }

    @Test
    public void testExibirAlunosPorNome() {
        gerenciadorAlunos.adicionarAluno("João", 12345L, 8.5);
        gerenciadorAlunos.adicionarAluno("Ana", 54321L, 7.5);
        gerenciadorAlunos.exibirAlunosPorNome();  // Verificar manualmente se a ordem por nome está correta
    }

    @Test
    public void testExibirAlunosPorNota() {
        gerenciadorAlunos.adicionarAluno("João", 12345L, 8.5);
        gerenciadorAlunos.adicionarAluno("Ana", 54321L, 7.5);
        gerenciadorAlunos.exibirAlunosPorNota();  // Verificar manualmente se a ordem por nota está correta
    }

    @Test
    public void testExibirAlunosComConjuntoVazio() {
        gerenciadorAlunos.exibirAlunos();  // Verificar manualmente se a mensagem de conjunto vazio é exibida
    }
}
