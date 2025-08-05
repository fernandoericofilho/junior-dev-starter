package arrays;

public class exerc24 {

    public static void main(String[] args) {

        //Faça um programa que inverta um array.

        int[] numeros = {1, 2, 3, 4, 5};

        System.out.println("Array original:");
        for (int num : numeros) {
            System.out.print(num + " ");
        }

        for (int i = 0; i < numeros.length / 2; i++) {
            int temp = numeros[i];
            numeros[i] = numeros[numeros.length - 1 - i];
            numeros[numeros.length - 1 - i] = temp;
        }

        System.out.println("\nArray invertido:");
        for (int num : numeros) {
            System.out.print(num + " ");
        }
    }
}
