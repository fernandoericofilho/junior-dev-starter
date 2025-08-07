import java.util.Scanner;

public class Exercicio23 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Digite a quantidade de números: ");
        int quantidade = scanner.nextInt();
        int[] numeros = new int[quantidade];
        for (int i = 0; i < quantidade; i++) {
            System.out.print("Digite o " + (i + 1) + "º número: ");
            numeros[i] = scanner.nextInt();
        }
        int maior = numeros[0];
        for (int i = 0; i < quantidade; i++) {
            if (i != 0) {
                if (numeros[i] > maior) {
                    maior = numeros[i];
                }
            }
        }
        System.out.println("O maior número é " + maior);
        scanner.close();
    }
}
