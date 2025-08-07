import ClassesEObjetos.Pessoa;

public class EXERCICIO36 {
    public static void main(String[] args) {
        // Criando o objeto 'pessoa1' a partir da classe 'Pessoa'
        Pessoa pessoa1 = new Pessoa("Lucas", 25);

        // Criando outro objeto 'pessoa2'
        Pessoa pessoa2 = new Pessoa("Maria", 30);

        System.out.println("Dados da primeira pessoa:");
        pessoa1.exibirDados(); // Chamando o método do objeto pessoa1

        System.out.println("\nDados da segunda pessoa:");
        pessoa2.exibirDados(); // Chamando o método do objeto pessoa2
    }
}