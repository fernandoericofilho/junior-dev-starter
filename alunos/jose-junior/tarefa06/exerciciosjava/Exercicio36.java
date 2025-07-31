public class Exercicio36 {
    public static void main(String[] args) {
        Pessoa pessoa1 = new Pessoa();
        pessoa1.setNome("João");
        pessoa1.setIdade(25);
        Pessoa pessoa2 = new Pessoa("Maria", 26);
        pessoa1.exibirDados();
        pessoa2.exibirDados();
    }
}