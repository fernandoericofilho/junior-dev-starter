package arrays;

public class exerc22 {

    public static void main(String[] args) {

        //Calcule a média de um array de double.

        double[] valores = {8.5, 7.0, 9.5, 6.0, 7.5};

        double soma = 0;
        for (double v : valores) {
            soma += v;
        }

        double media = soma / valores.length;

        System.out.println("A média é: " + media);
    }
}
