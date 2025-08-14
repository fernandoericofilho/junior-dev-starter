public class EXERCICIO05 {
    public static void main(String[] args) {
        // 'final' cria uma constante. Seu valor não pode ser alterado após a inicialização.
        final double VALOR_DE_PI = 3.14159;

        System.out.println("O valor da constante PI é: " + VALOR_DE_PI);

        // A linha abaixo, se for descomentada, causará um erro de compilação.
        // O IntelliJ provavelmente já vai sublinhá-la em vermelho.
        // VALOR_DE_PI = 3.14; // ERRO: Cannot assign a value to final variable 'VALOR_DE_PI'

        System.out.println("Tentativa de alteração (comentada para evitar erro).");
    }
}