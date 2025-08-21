public class EXERCICIO23 {
    public static void main(String[] args) {
        int[] valores = {15, 78, 32, 94, 56, 8, 99, 43};

        // Começamos assumindo que o maior valor é o primeiro elemento do array
        int maiorValor = valores[0];

        // Percorremos o array a partir do SEGUNDO elemento (índice 1)
        for (int i = 1; i < valores.length; i++) {
            // Se o valor atual (valores[i]) for maior que o nosso 'maiorValor' atual...
            if (valores[i] > maiorValor) {
                // ...então atualizamos o 'maiorValor' para este novo número.
                maiorValor = valores[i];
            }
        }

        System.out.println("O maior valor no array é: " + maiorValor);
    }
}