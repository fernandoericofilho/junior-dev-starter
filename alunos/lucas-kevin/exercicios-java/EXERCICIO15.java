import java.util.Scanner;

public class EXERCICIO15 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("--- Calculadora Simples ---");
        System.out.println("1: Somar");
        System.out.println("2: Subtrair");
        System.out.println("3: Multiplicar");
        System.out.println("4: Dividir");
        System.out.print("Escolha uma opção (1-4): ");
        int escolha = scanner.nextInt();

        System.out.print("Digite o primeiro número: ");
        double num1 = scanner.nextDouble();

        System.out.print("Digite o segundo número: ");
        double num2 = scanner.nextDouble();

        if (escolha == 1) {
            System.out.println("Resultado: " + (num1 + num2));
        } else if (escolha == 2) {
            System.out.println("Resultado: " + (num1 - num2));
        } else if (escolha == 3) {
            System.out.println("Resultado: " + (num1 * num2));
        } else if (escolha == 4) {
            if (num2 != 0) {
                System.out.println("Resultado: " + (num1 / num2));
            } else {
                System.out.println("Erro: Divisão por zero não é permitida.");
            }
        } else {
            System.out.println("Opção inválida!");
        }

        scanner.close();
    }
}