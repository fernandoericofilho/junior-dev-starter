package operadoresAritmeticosELogicos;

import java.util.Scanner;

public class exerc9 {

    public static void main(String[] args) {

        //Crie um programa que teste expressões booleanas com operadores &&, || e !.

        Scanner scanner = new Scanner(System.in);

        System.out.print("Digite 1 para verdadeiro ou 0 para falso (valor A): ");
        int a = scanner.nextInt();

        System.out.print("Digite 1 para verdadeiro ou 0 para falso (valor B): ");
        int b = scanner.nextInt();

        boolean valorA = (a == 1);
        boolean valorB = (b == 1);

        boolean eLogico = valorA && valorB;
        boolean ouLogico = valorA || valorB;
        boolean naoA = !valorA;

        System.out.println("Resultado de A && B: " + eLogico);
        System.out.println("Resultado de A || B: " + ouLogico);
        System.out.println("Resultado de !A: " + naoA);

        scanner.close();
    }
}
