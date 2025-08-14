import ClassesEObjetos.Pessoa;

public class EXERCICIO41 {
    public static void main(String[] args) {
        Pessoa p1 = new Pessoa("Carlos", 40);

        System.out.println("--- Dados Iniciais ---");
        p1.exibirDados();

        // Modificando os dados usando os SETTERS
        System.out.println("\n--- Modificando os dados ---");
        p1.setNome("Carlos Souza");
        p1.setIdade(41); // Valor válido
        p1.exibirDados();

        System.out.println("\n--- Tentando inserir valor inválido ---");
        p1.setIdade(-10); // Valor inválido, a validação no setter vai agir
        p1.exibirDados(); // A idade deve continuar 41
    }
}