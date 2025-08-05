package estruturasCondicionais;

import java.util.Scanner;

public class exerc11 {

    public static void main(String[] args) {

        //Escreva um programa que verifique se uma pessoa pode votar (idade ≥ 16).

        Scanner scanner = new Scanner(System.in);

        System.out.print("Digite sua idade: ");
        int idade = scanner.nextInt();

        if (idade >= 16) {
            System.out.println("Você pode votar!");
        } else {
            System.out.println("Você ainda não pode votar.");
        }

        scanner.close();
    }
}
