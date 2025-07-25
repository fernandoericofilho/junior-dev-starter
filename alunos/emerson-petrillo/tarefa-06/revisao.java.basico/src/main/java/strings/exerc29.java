package strings;

import java.util.Scanner;

public class exerc29 {

    public static void main(String[] args) {

        //Inverta uma String (ex: "abc" → "cba").

        Scanner scanner = new Scanner(System.in);

        System.out.print("Digite uma palavra: ");
        String original = scanner.nextLine();

        String invertida = new StringBuilder(original).reverse().toString();

        System.out.println("String invertida: " + invertida);

        scanner.close();
    }
}
