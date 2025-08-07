import java.util.Scanner;

public class Exercicio10 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Digite um número: ");
        int numero = scanner.nextInt();
        if (numero >= 10 && numero <= 100) {
            System.out.println("O número " + numero + " está entre entre 10 e 100.");
        } else {
            System.out.println("O número " + numero + " não está entre 10 e 100.");
        }
        scanner.close();
    }
}
