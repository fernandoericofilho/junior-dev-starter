package arrays;

public class exerc25 {

    public static void main(String[] args) {

        //Escreva um programa que conte quantos números pares existem em um array.

        int[] numeros = {2, 7, 4, 9, 6, 1, 8, 3, 10};

        int pares = 0;

        for (int num : numeros) {
            if (num % 2 == 0) {
                pares++;
            }
        }

        System.out.println("Quantidade de números pares: " + pares);
    }
}
