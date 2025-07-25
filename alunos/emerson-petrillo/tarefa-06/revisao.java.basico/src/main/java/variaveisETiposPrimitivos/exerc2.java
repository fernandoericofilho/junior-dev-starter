package variaveisETiposPrimitivos;

import java.util.Scanner;

public class exerc2 {

    public static void main(String[] args) {

        //Crie um programa que converta um valor em graus Celsius para Fahrenheit.

        Scanner scanner = new Scanner(System.in);

        System.out.print("Digite a temperatura em graus Celsius(°C): ");

        double celsius = scanner.nextDouble();
        double fahrenheit = (celsius * 1.8) + 32;

        System.out.printf("O valor de %.1f°C equivale a %.1f°F\n", celsius, fahrenheit);

        scanner.close();
    }
}
