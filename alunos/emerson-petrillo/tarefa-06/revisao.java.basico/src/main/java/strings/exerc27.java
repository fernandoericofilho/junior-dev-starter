package strings;

import java.util.Scanner;

public class exerc27 {

    public static void main(String[] args) {

        //Escreva um programa que verifique se duas Strings são iguais.

        Scanner scanner = new Scanner(System.in);

        System.out.print("Digite a primeira string: ");
        String string1 = scanner.nextLine();

        System.out.print("Digite a segunda string: ");
        String string2 = scanner.nextLine();

        if (string1.equals(string2)) {
            System.out.println("As strings são iguais.");
        } else {
            System.out.println("As strings são diferentes.");
        }

        scanner.close();
    }
}
