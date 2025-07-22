package org.example;
import java.util.Scanner;
public class ConverterCelsiusFahrenheit {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Digite o valor da temperatura em Celsius:");
        double var1 = scanner.nextDouble();

        double fahrenheit = converterCelsius(var1);
        System.out.println("O valor da temperatura" + var1 + " C em fahrenheit eh: " + fahrenheit);
    }
    public static double converterCelsius(double var1 ){
        return (var1 * 1.8) + 32;
    }
}
