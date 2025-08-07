import java.util.Scanner;

public class EXERCICIO19 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Digite um número para calcular o fatorial: ");
        int numero = scanner.nextInt();

        // Usamos long para o fatorial, pois ele cresce muito rápido
        long fatorial = 1;

        // Fatorial de 0 é 1, então o laço lida com isso corretamente
        // O laço multiplica o resultado pelos números de 1 até o número digitado
        for (int i = 1; i <= numero; i++) {
            fatorial = fatorial * i; // ou a forma abreviada: fatorial *= i;
        }

        System.out.println("O fatorial de " + numero + " é: " + fatorial);
        scanner.close();
    }
}