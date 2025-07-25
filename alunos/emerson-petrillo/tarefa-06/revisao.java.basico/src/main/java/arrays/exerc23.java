package arrays;

public class exerc23 {

    public static void main(String[] args) {

        //Escreva um programa que encontre o maior valor em um array.

        int[] numeros = {12, 45, 7, 89, 32, 67, 99, 3, 28, 74};

        int maior = numeros[0];

        for (int i = 1; i < numeros.length; i++) {
            if (numeros[i] > maior) {
                maior = numeros[i];
            }
        }

        System.out.println("O maior valor do array é: " + maior);
    }
}
