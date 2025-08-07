import java.util.Scanner;

public class Exercicio32 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Digite um número e eu direi se ele é primo: ");
        int numero = scanner.nextInt();
        boolean primo = ehPrimo(numero);
        if (primo) {
            System.out.println(numero + " é primo!");
        } else {
            System.out.println(numero + " não é primo!");
        }
        scanner.close();
    }

    public static boolean ehPrimo(int numero) {
        int divisores = 0;
        for (int i = 1; i <= numero; i++) {
            if (numero % i == 0) {
                divisores++;
            }
        }
        if (divisores > 2) {
            return false;
        } else {
            return true;
        }
    }
}
