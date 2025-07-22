package org.example;
import java.util.Scanner;
public class TrocaValor {
    public static void main(String[] var0) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Digite um valor: ");
        double var1 = scanner.nextDouble();
        System.out.println("Digite um segundo valor: ");
        double var2 = scanner.nextDouble();
        trocaDeValores(var1, var2);
    }
    public static void trocaDeValores(double var1, double var2){
        System.out.println("Antes da troca:\n Valor: " + var1 + "\n Valor: " + var2);
        var1 = var1 + var2;
        var2 = var1 - var2;
        var1 = var1 - var2;
        System.out.println("Depois de troca:\n Valor: " + var1 + "\n Valor: " + var2);
    }
}
