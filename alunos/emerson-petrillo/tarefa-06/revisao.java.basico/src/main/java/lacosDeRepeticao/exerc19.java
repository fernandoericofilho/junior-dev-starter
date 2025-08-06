package lacosDeRepeticao;

import java.util.Scanner;

public class exerc19 {

    public static void main(String[] args) {

        //Calcule o fatorial de um número com for.

        Scanner scanner = new Scanner(System.in);

        System.out.print("Digite um número inteiro positivo: ");
        int numero = scanner.nextInt();

        long fatorial = 1;

        for (int i = 1; i <= numero; i++) {
            fatorial *= i;
        }

        System.out.println("O fatorial de " + numero + " é: " + fatorial);

        scanner.close();
    }
}
