package operadoresAritmeticosELogicos;

import java.util.Scanner;

public class exerc10 {

    public static void main(String[] args) {

        //Escreva um programa que determine se um número está entre 10 e 100.

        Scanner scanner = new Scanner(System.in);

        System.out.print("Digite um número: ");
        int numero = scanner.nextInt();

        if (numero >= 10 && numero <= 100) {
            System.out.println("O número " + numero + " está entre 10 e 100.");
        } else {
            System.out.println("O número " + numero + " NÃO está entre 10 e 100.");
        }

        scanner.close();
    }
}
