public class EXERCICIO18 {
    public static void main(String[] args) {
        int soma = 0; // Variável "acumuladora" para guardar o resultado

        for (int i = 1; i <= 100; i++) {
            // A cada volta, adicionamos o valor atual de 'i' à variável 'soma'
            soma = soma + i; // ou a forma abreviada: soma += i;
        }

        System.out.println("A soma de todos os números de 1 a 100 é: " + soma);
        // O resultado esperado é 5050
    }
}