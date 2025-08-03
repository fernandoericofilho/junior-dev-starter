package metodos;

public class exerc35 {

    public static void main(String[] args) {

        //Crie um metodo que receba um array de inteiros e retorne a média.

        int[] meusNumeros = {15, 25, 30, 50};
        double media = calcularMedia(meusNumeros);
        System.out.println("A média dos números é: " + media);

        int[] outrosNumeros = {1, 2, 4};
        double outraMedia = calcularMedia(outrosNumeros);
        System.out.println("A média dos outros números é: " + outraMedia);

        int[] arrayVazio = {};
        double mediaVazia = calcularMedia(arrayVazio);
        System.out.println("A média de um array vazio é: " + mediaVazia);
    }

    public static double calcularMedia(int[] numeros) {
        if (numeros == null || numeros.length == 0) {
            return 0.0;
        }
        double soma = 0;
        for (int numero : numeros) {
            soma = soma + numero;
        }
        return soma / numeros.length;
    }
}