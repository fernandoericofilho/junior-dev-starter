import java.util.Scanner;

public class Exercicio19 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Digite um número: ");
        int n = scanner.nextInt();
        int fatorial = 1;
        for (int i = n; i >= 1; i--) {
            fatorial *= i;
        }
        System.out.println("O fatorial de " + n + " é " + fatorial);
        scanner.close();
    }
}