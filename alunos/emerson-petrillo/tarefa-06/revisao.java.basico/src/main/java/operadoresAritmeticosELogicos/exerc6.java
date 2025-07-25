package operadoresAritmeticosELogicos;

import java.util.Scanner;

public class exerc6 {

    public static void main(String[] args) {

        //Escreva um programa que leia dois números inteiros e exiba a soma, subtração, multiplicação e divisão.

        Scanner scanner = new Scanner(System.in);

        System.out.print("Digite o primeiro número inteiro: ");
        int num1 = scanner.nextInt();

        System.out.print("Digite o segundo número inteiro: ");
        int num2 = scanner.nextInt();

        int soma = num1 + num2;
        int subtracao = num1 - num2;
        int multiplicacao = num1 * num2;
        double divisao;
        if (num1==0 || num2==0){
            divisao = 0;
        } else {
            if (num1 > num2){
                divisao = (double) num1 / num2;
            } else {
                divisao = (double) num2 / num1;
            }
        }

        System.out.println("Soma: " + soma);
        System.out.println("Subtração: " + subtracao);
        System.out.println("Multiplicação: " + multiplicacao);
        if (divisao == 0){
            System.out.println("Não é possível dividir por zero.");
        } else {
            System.out.println("Divisão: " + divisao);
        }

        scanner.close();
    }
}
