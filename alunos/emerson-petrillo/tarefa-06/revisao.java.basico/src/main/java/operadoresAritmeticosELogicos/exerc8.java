package operadoresAritmeticosELogicos;

import java.util.Scanner;

public class exerc8 {

    public static void main(String[] args) {

        //Faça um programa que verifique se um número é par ou ímpar usando o operador %.

        Scanner scanner = new Scanner(System.in);

        System.out.print("Digite um número: ");
        int numero = scanner.nextInt();

        if (numero % 2 == 0) {
            System.out.println(numero + " é par.");
        } else {
            System.out.println(numero + " é ímpar.");
        }

        scanner.close();
    }
}
