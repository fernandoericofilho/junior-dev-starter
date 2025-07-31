import java.util.Scanner;

public class Exercicio35 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Digite a quantidade de valores do array: ");
        int qtNumeros = scanner.nextInt();
        int[] arrayNumeros = new int[qtNumeros];
        for (int i = 0; i < qtNumeros; i++) {
            System.out.print("Digite o " + (i + 1) + "º número: ");
            arrayNumeros[i] = scanner.nextInt();
        }
        double media = calcularMedia(arrayNumeros);
        System.out.println("A média dos números informados é " + media);
        scanner.close();
    }

    public static double calcularMedia(int[] numeros) {
        int somatorio = 0;
        int quantidade = numeros.length;
        for (int i = 0; i < quantidade; i++) {
            somatorio += numeros[i];
        }
        double media = somatorio / quantidade;
        return media;

    }
}
