package operadoresAritmeticosELogicos;

import java.util.Scanner;

public class exerc7 {

    public static void main(String[] args) {

        //Crie um programa que calcule o resto da divisão de dois números.

        Scanner scanner = new Scanner(System.in);

        System.out.print("Digite o primeiro número: ");
        double num1 = scanner.nextDouble();

        System.out.print("Digite o segundo número: ");
        double num2 = scanner.nextDouble();

        if (num1==0 || num2==0){
            System.out.println("Não é possível dividir por zero.");
        } else {
            if (num1 > num2){
                double resto = num1 % num2;
                System.out.println("O resto da divisão é: " + resto);
            } else {
                double resto = num2 % num1;
                System.out.println("O resto da divisão é: " + resto);
            }
        }

        scanner.close();
    }
}
