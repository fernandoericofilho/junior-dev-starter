package strings;

import java.util.Scanner;

public class exerc28 {

    public static void main(String[] args) {

        //Leia uma frase e substitua todas as ocorrências de "Java" por "Kotlin".

        Scanner scanner = new Scanner(System.in);

        System.out.print("Digite uma frase: ");
        String frase = scanner.nextLine();

        String novaFrase = frase.replaceAll("(?i)java", "Kotlin");

        System.out.println("Frase modificada: " + novaFrase);

        scanner.close();
    }
}
