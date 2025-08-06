import java.util.Arrays;

public class EXERCICIO24 {
    public static void main(String[] args) {
        int[] arrayOriginal = {1, 2, 3, 4, 5, 6, 7};

        System.out.println("Array Original: " + Arrays.toString(arrayOriginal));

        // Percorremos o array apenas até a metade
        for (int i = 0; i < arrayOriginal.length / 2; i++) {
            // 1. Guarda o valor do elemento do início
            int temp = arrayOriginal[i];

            // 2. O elemento do início recebe o valor do elemento correspondente do final
            int indiceDoFinal = arrayOriginal.length - 1 - i;
            arrayOriginal[i] = arrayOriginal[indiceDoFinal];

            // 3. O elemento do final recebe o valor que guardamos no início
            arrayOriginal[indiceDoFinal] = temp;
        }

        System.out.println("Array Invertido: " + Arrays.toString(arrayOriginal));
    }
}