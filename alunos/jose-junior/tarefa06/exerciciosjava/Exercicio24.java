import java.util.Scanner;

public class Exercicio24 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Digite a quantidade de valores do Array: ");
        int quantidade = scanner.nextInt();
        int[] array = new int[quantidade];
        for (int i = 0; i < quantidade; i++) {
            System.out.print("Digite o " + (i + 1) + "º valor do array: ");
            array[i] = scanner.nextInt();
        }
        int[] arrayInvertido = new int[quantidade];
        for (int i = 0; i < quantidade; i++) {
            int posicao = quantidade - (i + 1);
            arrayInvertido[i] = array[posicao];
        }
        System.out.print("Array: ");
        for (int i = 0; i < quantidade; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.print("\nArray Invertido: ");
        for (int i = 0; i < quantidade; i++) {
            System.out.print(arrayInvertido[i] + " ");
        }
        scanner.close();
    }   
}
