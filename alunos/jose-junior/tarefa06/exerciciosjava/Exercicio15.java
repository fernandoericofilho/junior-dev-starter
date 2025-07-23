import java.util.Scanner;

public class Exercicio15 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("--- Calculadora Aritmética ---");
        System.out.println("Digite + para realizar a soma entre dois números.");
        System.out.println("Digite - para realizar a subtração entre dois números.");
        System.out.println("Digite * para realizar a multiplicação entre dois números.");
        System.out.println("Digite / para realizar a divisão entre dois números.");
        System.out.print("Qual operação você deseja realizar? ");
        String operacao = scanner.next();
        if (operacao.equals("+")) {
            System.out.print("Digite o primeiro número: ");
            int n1 = scanner.nextInt();
            System.out.print("Digite o segundo número: ");
            int n2 = scanner.nextInt();
            System.out.println("A soma entre " + n1 + " e " + n2 + " é " + (n1 + n2));
        } else if (operacao.equals("-")) {
            System.out.print("Digite o primeiro número: ");
            int n1 = scanner.nextInt();
            System.out.print("Digite o segundo número: ");
            int n2 = scanner.nextInt();
            System.out.println("A subtração entre " + n1 + " e " + n2 + " é " + (n1 - n2));
        } else if (operacao.equals("*")) {
            System.out.print("Digite o primeiro número: ");
            int n1 = scanner.nextInt();
            System.out.print("Digite o segundo número: ");
            int n2 = scanner.nextInt();
            System.out.println("A multiplicação entre " + n1 + " e " + n2 + " é " + (n1 * n2));
        } else if (operacao.equals("/")) {
            System.out.print("Digite o primeiro número: ");
            int n1 = scanner.nextInt();
            System.out.print("Digite o segundo número: ");
            int n2 = scanner.nextInt();
            System.out.println("A divisão entre " + n1 + " e " + n2 + " é " + (n1 / n2));
        } else {
            System.out.println("Operação inválida!");
        }
        scanner.close();
    }
}