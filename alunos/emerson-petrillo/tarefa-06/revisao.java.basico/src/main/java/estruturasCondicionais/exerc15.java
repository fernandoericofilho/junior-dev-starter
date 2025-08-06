package estruturasCondicionais;

import java.util.Scanner;

public class exerc15 {

    public static void main(String[] args) {

        //Simule um menu de opções com if-else para operações matemáticas básicas.

        Scanner scanner = new Scanner(System.in);

        System.out.println("Menu de Operações Matemáticas Básicas");
        System.out.println("1 - Soma");
        System.out.println("2 - Subtração");
        System.out.println("3 - Multiplicação");
        System.out.println("4 - Divisão");
        System.out.print("Escolha uma opção: ");

        int opcao = scanner.nextInt();

        System.out.print("Digite o primeiro número: ");
        double num1 = scanner.nextDouble();

        System.out.print("Digite o segundo número: ");
        double num2 = scanner.nextDouble();

        if (opcao == 1) {
            double resultado = num1 + num2;
            System.out.println("Resultado da soma: " + resultado);
        } else if (opcao == 2) {
            double resultado = num1 - num2;
            System.out.println("Resultado da subtração: " + resultado);
        } else if (opcao == 3) {
            double resultado = num1 * num2;
            System.out.println("Resultado da multiplicação: " + resultado);
        } else if (opcao == 4) {
            if (num1==0 || num2==0){
                System.out.println("Não é possível dividir por zero.");
            } else if (num1 > num2){
                double resultado = num1 / num2;
                System.out.println("Resultado da divisão: " + resultado);
            } else {
                double resultado = num2 / num1;
                System.out.println("Resultado da divisão: " + resultado);
            }
        } else {
            System.out.println("Opção inválida.");
        }

        scanner.close();
    }
}
