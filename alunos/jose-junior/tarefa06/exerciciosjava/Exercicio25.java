import java.util.Scanner;

public class Exercicio25 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Digite a quantidade de valores do array: ");
        int quantidade = scanner.nextInt();
        int[] numeros = new int[quantidade];
        for (int i = 0; i < quantidade; i++) {
            System.out.print("Digite o " + (i + 1) + "º número: ");
            numeros[i] = scanner.nextInt();
        }
        int contador = 0;
        for (int i = 0; i < quantidade; i++) {
            if (numeros[i] % 2 == 0) {
                contador++;
            }
        }
        System.out.println("Foram inseridos " + contador + " números pares no array.");
        scanner.close();
    }
}
