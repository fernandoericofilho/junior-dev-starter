// Precisamos importar a classe Scanner para ler a entrada do teclado
import java.util.Scanner;

public class EXERCICIO06 {
    public static void main(String[] args) {
        // Cria um objeto Scanner para ler a partir do console (System.in)
        Scanner scanner = new Scanner(System.in);

        // Pede e lê o primeiro número
        System.out.print("Digite o primeiro número inteiro: ");
        int numero1 = scanner.nextInt();

        // Pede e lê o segundo número
        System.out.print("Digite o segundo número inteiro: ");
        int numero2 = scanner.nextInt();

        // Realiza as operações
        int soma = numero1 + numero2;
        int subtracao = numero1 - numero2;
        int multiplicacao = numero1 * numero2;

        System.out.println("\n--- Resultados ---");
        System.out.println(numero1 + " + " + numero2 + " = " + soma);
        System.out.println(numero1 + " - " + numero2 + " = " + subtracao);
        System.out.println(numero1 + " * " + numero2 + " = " + multiplicacao);

        // Para a divisão, precisamos ter cuidado para não dividir por zero
        if (numero2 != 0) {
            // Convertemos um dos números para double para obter um resultado com casas decimais
            double divisao = (double) numero1 / numero2;
            System.out.println(numero1 + " / " + numero2 + " = " + divisao);
        } else {
            System.out.println("Não é possível dividir por zero.");
        }

        // É uma boa prática fechar o scanner quando não for mais usá-lo
        scanner.close();
    }
}