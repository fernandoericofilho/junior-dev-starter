import java.util.Scanner;

public class Exercicio30 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Digite alguma palavra e eu direi se ela é um palíndromo ou não: ");
        String palavra = scanner.next();
        char[] arrayChar = palavra.toCharArray();
        String palavraInvertida = "";
        for (int i = (arrayChar.length - 1); i >= 0; i--) {
            palavraInvertida += arrayChar[i];
        }
        if ((palavra.toLowerCase()).equals(palavraInvertida.toLowerCase())) {
            System.out.println(palavra + " é um palíndromo");
        } else {
            System.out.println(palavra + " não é um palíndromo");
        }
        scanner.close();
    }
}
