import java.util.Arrays; // Importamos uma classe útil para imprimir arrays

public class EXERCICIO21 {
    public static void main(String[] args) {
        // Declara um array de inteiros com 10 posições (de 0 a 9)
        int[] numeros = new int[10];

        // Usa um laço 'for' para preencher o array
        // O índice do array (i) vai de 0 a 9
        for (int i = 0; i < 10; i++) {
            // O valor a ser inserido é o índice + 1 (para ir de 1 a 10)
            numeros[i] = i + 1;
        }

        // Imprime o array no console para verificar
        // Arrays.toString() é um atalho para formatar o array de forma legível
        System.out.println("Array preenchido: " + Arrays.toString(numeros));
    }
}