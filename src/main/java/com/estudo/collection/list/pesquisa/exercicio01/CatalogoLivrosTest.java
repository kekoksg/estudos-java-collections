package com.estudo.collection.list.pesquisa.exercicio01;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class CatalogoLivrosTest {
    private CatalogoLivros catalogo;

    @BeforeEach
    public void setUp() {
        catalogo = new CatalogoLivros();
        catalogo.adicionarLivro("O Senhor dos Anéis", "J.R.R. Tolkien", 1954);
        catalogo.adicionarLivro("1984", "George Orwell", 1949);
        catalogo.adicionarLivro("A Revolução dos Bichos", "George Orwell", 1945);
        catalogo.adicionarLivro("Dom Casmurro", "Machado de Assis", 1899);
    }

    @Test
    public void testPesquisarPorAutor() {
        List<Livro> livros = catalogo.pesquisarPorAutor("George Orwell");
        assertEquals(2, livros.size());
        assertTrue(livros.stream().anyMatch(l -> l.getTitulo().equals("1984")));
        assertTrue(livros.stream().anyMatch(l -> l.getTitulo().equals("A Revolução dos Bichos")));
    }

    @Test
    public void testPesquisarPorIntervaloAnos() {
        List<Livro> livros = catalogo.pesquisarPorIntervaloAnos(1940, 1950);
        assertEquals(2, livros.size());
        assertTrue(livros.stream().anyMatch(l -> l.getTitulo().equals("1984")));
        assertTrue(livros.stream().anyMatch(l -> l.getTitulo().equals("A Revolução dos Bichos")));
    }

    @Test
    public void testPesquisarPorTitulo() {
        Livro livro = catalogo.pesquisarPorTitulo("Dom Casmurro");
        assertNotNull(livro);
        assertEquals("Machado de Assis", livro.getAutor());
        assertEquals(1899, livro.getAnoPublicacao());
    }

    @Test
    public void testPesquisarPorTituloInexistente() {
        RuntimeException thrown = assertThrows(RuntimeException.class,
                () -> catalogo.pesquisarPorTitulo("Título Inexistente"));
        assertEquals("Livro não encontrado", thrown.getMessage());
    }

    @Test
    public void testPesquisarPorAutorListaVazia() {
        catalogo = new CatalogoLivros(); // Reinicia o catálogo para uma lista vazia
        RuntimeException thrown = assertThrows(RuntimeException.class,
                () -> catalogo.pesquisarPorAutor("Qualquer Autor"));
        assertEquals("Lista de livros vazia", thrown.getMessage());
    }

    @Test
    public void testPesquisarPorIntervaloAnosListaVazia() {
        catalogo = new CatalogoLivros(); // Reinicia o catálogo para uma lista vazia
        RuntimeException thrown = assertThrows(RuntimeException.class,
                () -> catalogo.pesquisarPorIntervaloAnos(1900, 2000));
        assertEquals("Lista de livros vazia", thrown.getMessage());
    }
}
