import java.util.Scanner;

public class EXERCICIO08 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Digite um número inteiro para verificar se é par ou ímpar: ");
        int numero = scanner.nextInt();

        // Se o resto da divisão do número por 2 for 0, ele é par.
        if (numero % 2 == 0) {
            System.out.println("O número " + numero + " é PAR.");
        } else {
            System.out.println("O número " + numero + " é ÍMPAR.");
        }

        scanner.close();
    }
}