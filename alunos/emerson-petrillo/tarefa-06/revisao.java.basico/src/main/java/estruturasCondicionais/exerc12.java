package estruturasCondicionais;

import java.util.Scanner;

public class exerc12 {

    public static void main(String[] args) {

        //Crie um programa que determine se um número é positivo, negativo ou zero.

        Scanner scanner = new Scanner(System.in);

        System.out.print("Digite um número: ");
        double numero = scanner.nextDouble();

        if (numero > 0) {
            System.out.println("O número é positivo.");
        } else if (numero < 0) {
            System.out.println("O número é negativo.");
        } else {
            System.out.println("O número é zero.");
        }

        scanner.close();
    }
}
