package com.estudo.collection.set.ordenacao.exercicio02;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class GerenciadorAlunos {
    private Set<Aluno> conjuntoAluno;

    public GerenciadorAlunos(){
        this.conjuntoAluno = new HashSet<>();
    }

    public void adicionarAluno(String nome, long matricula, double nota) {
        this.conjuntoAluno.add(new Aluno(nome, matricula, nota));
    }

    private Aluno obterAlunoPorMatricula(long matricula) {
        Aluno alunoPorMatricula = null;

        for (Aluno aluno : conjuntoAluno) {
            if (aluno.getMatricula() == matricula) {
                alunoPorMatricula = aluno;
            }
        }

        return alunoPorMatricula;
    }


    public void removerAluno(long matricula) {
        if (this.conjuntoAluno.isEmpty()) {
            System.out.println("Conjunto de alunos está vazio");
            return;
        }

        Aluno alunoParaRemover = obterAlunoPorMatricula(matricula);

        if (alunoParaRemover != null) {
            this.conjuntoAluno.remove(alunoParaRemover);
        } else {
            System.out.println("Aluno não encontrado");
        }
    }

    public void exibirAlunosPorNome() {
        if (this.conjuntoAluno.isEmpty()) {
            System.out.println("Conjunto de alunos está vazio");
            return;
        }

        Set<Aluno> alunosPorNome = new TreeSet<>(conjuntoAluno);
        System.out.println(alunosPorNome);
    }

    public void exibirAlunosPorNota() {
        if (this.conjuntoAluno.isEmpty()) {
            System.out.println("Conjunto de alunos está vazio");
            return;
        }

        Set<Aluno> alunosPorNota = new TreeSet<>(new ComparatorPorNota());
        alunosPorNota.addAll(conjuntoAluno);
        System.out.println(alunosPorNota);
    }

    public void exibirAlunos() {
        if (this.conjuntoAluno.isEmpty()) {
            System.out.println("Conjunto de alunos está vazio");
            return;
        }

        System.out.println(conjuntoAluno);
    }

    // Método para facilitar nos testes
    public boolean alunoExiste(long matricula) {
        return obterAlunoPorMatricula(matricula) != null;
    }
}
