public class EXERCICIO33 {

    // Método que recebe um número e retorna seu fatorial.
    public static long calcularFatorial(int numero) {
        if (numero < 0) {
            // Fatorial não é definido para números negativos.
            return -1; // Usamos -1 para indicar um erro.
        }

        long fatorial = 1;
        for (int i = 1; i <= numero; i++) {
            fatorial *= i;
        }
        return fatorial;
    }

    public static void main(String[] args) {
        int numero = 5;
        long resultado = calcularFatorial(numero);

        if (resultado != -1) {
            System.out.println("O fatorial de " + numero + " é: " + resultado);
        } else {
            System.out.println("Não é possível calcular o fatorial de um número negativo.");
        }
    }
}