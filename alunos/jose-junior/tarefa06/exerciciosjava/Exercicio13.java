import java.util.Scanner;

public class Exercicio13 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Digite o primeiro número: ");
        int n1 = scanner.nextInt();
        int maior = n1;
        System.out.print("Digite o segundo número: ");
        int n2 = scanner.nextInt();
        System.out.print("Digite o terceiro número: ");
        int n3 = scanner.nextInt();
        if (n2 > maior && n2 > n3) {
            maior = n2;
        } else if (n3 > maior && n3 > n2) {
            maior = n3;
        }
        System.out.println("O maior número entre " + n1 + ", " + n2 + " e " + n3 + " é " + maior);
        scanner.close();
    }
}
