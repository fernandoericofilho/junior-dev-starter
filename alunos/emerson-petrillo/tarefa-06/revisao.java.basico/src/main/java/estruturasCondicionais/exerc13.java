package estruturasCondicionais;

import java.util.Scanner;

public class exerc13 {

    public static void main(String[] args) {

        //Faça um programa que leia 3 números e diga qual é o maior.

        Scanner scanner = new Scanner(System.in);

        System.out.print("Digite três números: ");
        int num1 = scanner.nextInt();
        int num2 = scanner.nextInt();
        int num3 = scanner.nextInt();

        int maior;

        if (num1 >= num2 && num1 >= num3) {
            maior = num1;
        } else if (num2 >= num1 && num2 >= num3) {
            maior = num2;
        } else {
            maior = num3;
        }

        System.out.println("O maior número é: " + maior);

        scanner.close();
    }
}
