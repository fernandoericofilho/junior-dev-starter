package EncapsulamentoEConstrutores;

public class Livro {

    //exerc42
    //Crie uma classe Livro com construtor para título e autor.

    private String titulo;
    private String autor;

    public Livro(String titulo, String autor) {
        if (titulo == null || titulo.trim().isEmpty()) {
            this.titulo = "Título Desconhecido";
        } else {
            this.titulo = titulo;
        }
        if (autor == null || autor.trim().isEmpty()) {
            this.autor = "Autor Desconhecido";
        } else {
            this.autor = autor;
        }
    }

    public String getTitulo() {
        return this.titulo;
    }

    public String getAutor() {
        return this.autor;
    }

    public void exibirDetalhes() {
        System.out.println("Livro: " + this.titulo + " | Autor: " + this.autor);
    }
}

