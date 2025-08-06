import java.util.Scanner;

public class EXERCICIO28 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Digite uma frase que contenha a palavra 'Java':");
        String fraseOriginal = scanner.nextLine();

        // O método .replace() substitui todas as ocorrências de um texto por outro
        String novaFrase = fraseOriginal.replace("Java", "Kotlin");

        System.out.println("\nFrase Original: " + fraseOriginal);
        System.out.println("Nova Frase: " + novaFrase);

        scanner.close();
    }
}