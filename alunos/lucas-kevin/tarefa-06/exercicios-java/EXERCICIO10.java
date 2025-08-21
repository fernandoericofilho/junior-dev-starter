import java.util.Scanner;

public class EXERCICIO10 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Digite um número inteiro: ");
        int numero = scanner.nextInt();

        // Usamos o operador E (&&) para garantir que ambas as condições são verdadeiras:
        // O número precisa ser MAIOR OU IGUAL a 10 E MENOR OU IGUAL a 100.
        if (numero >= 10 && numero <= 100) {
            System.out.println("O número " + numero + " está entre 10 e 100.");
        } else {
            System.out.println("O número " + numero + " está fora do intervalo de 10 a 100.");
        }

        scanner.close();
    }
}