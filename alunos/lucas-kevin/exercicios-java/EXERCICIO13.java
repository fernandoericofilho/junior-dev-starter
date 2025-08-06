import java.util.Scanner;

public class EXERCICIO13 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Digite o primeiro número: ");
        int num1 = scanner.nextInt();

        System.out.print("Digite o segundo número: ");
        int num2 = scanner.nextInt();

        System.out.print("Digite o terceiro número: ");
        int num3 = scanner.nextInt();

        // Comparamos o primeiro com os outros dois
        if (num1 >= num2 && num1 >= num3) {
            System.out.println("O maior número é: " + num1);
        }
        // Se o primeiro não for o maior, comparamos o segundo com o terceiro
        else if (num2 >= num1 && num2 >= num3) {
            System.out.println("O maior número é: " + num2);
        }
        // Se nem o primeiro nem o segundo forem os maiores, então o terceiro é.
        else {
            System.out.println("O maior número é: " + num3);
        }

        scanner.close();
    }
}