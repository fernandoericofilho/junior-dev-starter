package arrays;

public class exerc21 {

    public static void main(String[] args) {

        //Declare um array de 10 inteiros e preencha com valores de 1 a 10.

        int[] numeros = new int[10];

        for (int i = 0; i < numeros.length; i++) {
            numeros[i] = i + 1;
        }

        for (int num : numeros) {
            System.out.print(num + " ");
        }

    }
}
