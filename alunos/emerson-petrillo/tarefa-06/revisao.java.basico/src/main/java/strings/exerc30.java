package strings;

import java.util.Scanner;

public class exerc30 {

    public static void main(String[] args) {

        //Verifique se uma String é um palíndromo (ex: "arara", "ana").

        Scanner scanner = new Scanner(System.in);

        System.out.print("Digite uma palavra: ");
        String texto = scanner.nextLine();

        String textoFormatado = texto.replaceAll("\\s+", "").toLowerCase();

        String invertido = new StringBuilder(textoFormatado).reverse().toString();

        if (textoFormatado.equals(invertido)) {
            System.out.println("É um palíndromo!");
        } else {
            System.out.println("Não é um palíndromo.");
        }

        scanner.close();
    }
}
