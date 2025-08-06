package strings;

import java.util.Scanner;

public class exerc26 {

    public static void main(String[] args) {

        //Crie um programa que leia uma String e imprima seu tamanho.

        Scanner scanner = new Scanner(System.in);

        System.out.print("Digite uma palavra: ");
        String palavra = scanner.nextLine();

        int tamanho = palavra.length();

        System.out.println("O tamanho da string é: " + tamanho);

        scanner.close();
    }
}
