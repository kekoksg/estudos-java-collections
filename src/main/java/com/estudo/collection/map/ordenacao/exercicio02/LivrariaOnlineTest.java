package com.estudo.collection.map.ordenacao.exercicio02;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Map;

public class LivrariaOnlineTest {

    private LivrariaOnline livraria;

    @BeforeEach
    void setUp() {
        livraria = new LivrariaOnline();
        livraria.adicionarLivro("link1", "Livro A", "Autor A", 50.0);
        livraria.adicionarLivro("link2", "Livro B", "Autor B", 40.0);
        livraria.adicionarLivro("link3", "Livro C", "Autor A", 60.0);
    }

    @Test
    void testAdicionarLivro() {
        livraria.adicionarLivro("link4", "Livro D", "Autor C", 70.0);

        // Verificar se o livro foi adicionado corretamente
        Livro livro = livraria.pesquisarLivrosPorAutor("Autor C").get("link4");
        assertNotNull(livro);
        assertEquals("Livro D", livro.getTitulo());
        assertEquals("Autor C", livro.getAutor());
        assertEquals(70.0, livro.getPreco());
    }

    @Test
    void testRemoverLivro() {
        livraria.removerLivro("Livro A");
        assertEquals(1, livraria.pesquisarLivrosPorAutor("Autor A").size());
        assertNull(livraria.pesquisarLivrosPorAutor("Autor A").get("link1"));
    }

    @Test
    void testRemoverLivro02() {
        livraria.removerLivro02("Livro A");
        assertEquals(1, livraria.pesquisarLivrosPorAutor("Autor A").size());
        assertNull(livraria.pesquisarLivrosPorAutor("Autor A").get("link1"));
    }

    @Test
    void testRemoverLivro03() {
        livraria.removerLivro03("Livro A");
        assertEquals(1, livraria.pesquisarLivrosPorAutor("Autor A").size());
        assertNull(livraria.pesquisarLivrosPorAutor("Autor A").get("link1"));
    }

    @Test
    void testExibirLivrosOrdenadosPorPreco() {
        Map<String, Livro> livrosOrdenados = livraria.exibirLivrosOrdenadosPorPreco();
        assertEquals("Livro B", livrosOrdenados.values().iterator().next().getTitulo());
    }

    @Test
    void testPesquisarLivrosPorAutor() {
        Map<String, Livro> livrosPorAutor = livraria.pesquisarLivrosPorAutor("Autor A");
        assertEquals(2, livrosPorAutor.size());
        assertNotNull(livrosPorAutor.get("link1"));
        assertNotNull(livrosPorAutor.get("link3"));
    }

    @Test
    void testObterLivroMaisCaro() {
        Livro livroMaisCaro = livraria.obterLivroMaisCaro();
        assertEquals("Livro C", livroMaisCaro.getTitulo());
    }

    @Test
    void testObterLivroMaisBarato() {
        Livro livroMaisBarato = livraria.obterLivroMaisBarato();
        assertEquals("Livro B", livroMaisBarato.getTitulo());
    }
}
