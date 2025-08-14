import java.util.Scanner;

public class EXERCICIO30 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Digite uma palavra para verificar se é um palíndromo: ");
        String palavra = scanner.nextLine();

        // 1. Usamos a mesma lógica do exercício anterior para inverter a palavra
        StringBuilder palavraInvertida = new StringBuilder();
        for (int i = palavra.length() - 1; i >= 0; i--) {
            palavraInvertida.append(palavra.charAt(i));
        }

        // 2. Comparamos a palavra original com a sua versão invertida
        // Usamos .equalsIgnoreCase() para que "Ana" seja considerado um palíndromo igual a "anA"
        if (palavra.equalsIgnoreCase(palavraInvertida.toString())) {
            System.out.println("A palavra '" + palavra + "' é um palíndromo!");
        } else {
            System.out.println("A palavra '" + palavra + "' não é um palíndromo.");
        }

        scanner.close();
    }
}