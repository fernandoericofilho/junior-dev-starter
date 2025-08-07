import java.util.Scanner;

public class Exercicio31 {
    public static int somarDoisNumeros(int numero1, int numero2) {
        return numero1 + numero2;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Digite o primeiro número: ");
        int n1 = scanner.nextInt();
        System.out.print("Digite o segundo número: ");
        int n2 = scanner.nextInt();
        System.out.println("A soma de " + n1 + " com " + n2 + " é igual a " + somarDoisNumeros(n1, n2));
        scanner.close();
    }
}
