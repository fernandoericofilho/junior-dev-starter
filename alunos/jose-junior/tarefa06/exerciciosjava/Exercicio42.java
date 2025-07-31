public class Exercicio42 {
    public static void main(String[] args) {
        Livro livro1 = new Livro();
        livro1.setTitulo("O Auto da Compadecida");
        livro1.setAutor("Ariano Suassuna");

        Livro livro2 = new Livro("1984", "George Orwell");

        livro1.exibirInformacoesDoLivro();
        livro2.exibirInformacoesDoLivro();
    }
}
