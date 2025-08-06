public class EXERCICIO25 {
    public static void main(String[] args) {
        int[] numeros = {2, 7, 8, 11, 14, 20, 23, 30};
        int contadorDePares = 0; // Inicia um contador

        // Percorre cada número no array
        for (int numero : numeros) {
            // Usa o operador módulo (%) para verificar se é par
            if (numero % 2 == 0) {
                contadorDePares++; // Se for par, incrementa o contador
            }
        }

        System.out.println("O array contém " + contadorDePares + " números pares.");
    }
}