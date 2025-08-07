package ClassesEObjetos;

public class Livro {
    private String titulo;
    private String autor;

    // Construtor para inicializar os atributos obrigatórios
    public Livro(String titulo, String autor) {
        this.titulo = titulo;
        this.autor = autor;
    }

    public void exibirInfo() {
        System.out.println("Livro: " + this.titulo + ", Autor: " + this.autor);
    }

    // Getters (boa prática)
    public String getTitulo() {
        return titulo;
    }

    public String getAutor() {
        return autor;
    }
}