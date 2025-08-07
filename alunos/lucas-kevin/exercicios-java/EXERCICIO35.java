public class EXERCICIO35 {

    // Método que recebe um array de inteiros e retorna um double (a média).
    public static double calcularMedia(int[] numeros) {
        // Lida com o caso de um array vazio ou nulo para evitar erros.
        if (numeros == null || numeros.length == 0) {
            return 0.0;
        }

        double soma = 0;
        for (int numero : numeros) {
            soma += numero;
        }

        return soma / numeros.length;
    }

    public static void main(String[] args) {
        int[] meuArray = {10, 20, 30, 40, 50};
        double media = calcularMedia(meuArray);
        System.out.println("A média do array é: " + media); // Esperado: 30.0

        int[] outroArray = {3, 5, 7, 9};
        double media2 = calcularMedia(outroArray);
        System.out.println("A média do outro array é: " + media2); // Esperado: 6.0
    }
}