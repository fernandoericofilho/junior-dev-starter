import java.util.Scanner;

public class EXERCICIO32 {

    // Este método recebe um inteiro e retorna um booleano (true ou false).
    public static boolean isPrimo(int numero) {
        // Números menores que 2 não são primos.
        if (numero < 2) {
            return false;
        }

        // Percorremos de 2 até a raiz quadrada do número.
        // Se encontrarmos qualquer divisor nesse intervalo, o número não é primo.
        for (int i = 2; i * i <= numero; i++) {
            if (numero % i == 0) {
                return false; // Encontrou um divisor, então não é primo.
            }
        }

        // Se o laço terminar sem encontrar divisores, o número é primo.
        return true;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Digite um número para verificar se é primo: ");
        int num = scanner.nextInt();

        if (isPrimo(num)) {
            System.out.println("O número " + num + " é primo.");
        } else {
            System.out.println("O número " + num + " não é primo.");
        }

        scanner.close();
    }
}