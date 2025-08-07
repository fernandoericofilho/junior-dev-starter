import java.util.Scanner;

public class EXERCICIO27 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Digite o primeiro texto: ");
        String texto1 = scanner.nextLine();

        System.out.print("Digite o segundo texto: ");
        String texto2 = scanner.nextLine();

        // MUITO IMPORTANTE: Para comparar o conteúdo de Strings, SEMPRE use o método .equals()
        // O operador '==' compara se as duas variáveis apontam para o mesmo objeto na memória,
        // o que nem sempre é o caso, mesmo que o texto seja igual.
        if (texto1.equals(texto2)) {
            System.out.println("Os textos são IGUAIS.");
        } else {
            System.out.println("Os textos são DIFERENTES.");
        }

        // Exemplo de comparação que ignora maiúsculas/minúsculas
        if (texto1.equalsIgnoreCase(texto2)) {
            System.out.println("(Considerando maiúsculas e minúsculas, eles são iguais)");
        }


        scanner.close();
    }
}