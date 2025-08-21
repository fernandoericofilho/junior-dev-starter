import ClassesEObjetos.Livro;

public class EXERCICIO42 {
    public static void main(String[] args) {
        // A criação do objeto (new) já exige os dados definidos no construtor
        Livro livro1 = new Livro("O Senhor dos Anéis", "J.R.R. Tolkien");
        Livro livro2 = new Livro("1984", "George Orwell");

        livro1.exibirInfo();
        livro2.exibirInfo();
    }
}