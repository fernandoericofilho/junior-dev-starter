public class Livro {
    private String titulo;
    private String autor;
    
    public Livro() {

    }

    public Livro(String titulo, String autor) {
        this.titulo = titulo;
        this.autor = autor;
    }

    public String getTitulo() {
        return this.titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    } 

    public String getAutor() {
        return this.autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public void exibirInformacoesDoLivro() {
        System.out.println("Livro: " + getTitulo() + " - " + getAutor());
    }
}
