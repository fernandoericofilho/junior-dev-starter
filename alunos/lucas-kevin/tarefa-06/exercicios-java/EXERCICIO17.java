public class EXERCICIO17 {
    public static void main(String[] args) {
        System.out.println("Imprimindo os números pares de 0 a 50:");

        int numero = 0; // 1. Inicializa o contador fora do laço

        while (numero <= 50) { // 2. Define a condição de parada
            // Verifica se o número atual é par
            if (numero % 2 == 0) {
                System.out.println(numero);
            }
            numero++; // 3. Incrementa o contador dentro do laço (MUITO IMPORTANTE!)
        }
    }
}