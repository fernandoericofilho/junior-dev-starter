import java.util.Scanner;

public class Exercicio22 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Digite a quantidade de notas: ");
        int quantidade = scanner.nextInt();
        double[] numeros = new double[quantidade];
        for (int i = 0; i < quantidade; i++) {
            System.out.print("Digite a sua " + (i + 1) + "ª nota: ");
            numeros[i] = scanner.nextDouble();
        }
        double soma = 0;
        for (int i = 0; i < quantidade; i++) {
            soma += numeros[i];
        }
        double media = soma / quantidade;
        System.out.println("A média das suas notas é " + media);
        scanner.close();
    }   
}
